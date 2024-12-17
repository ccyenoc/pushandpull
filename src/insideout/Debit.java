package insideout;

import static insideout.InsideOut.store; // method to store in main class
import static insideout.InsideOut.transactionID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Label;

public class Debit {
    private String username="";
    private String filepath="/Users/cye/NewFolder/InsideOut/src/recorddebitandcredit - Sheet1.csv";
    private double amount=0.0;
    private String description="";
    private String type="";
    private Label lbl=new Label();
    static String transactioninfo="";
    static int transactionID=1;
    static double balance=0.0;
    static ArrayList<String> getBalance=new ArrayList<>();
    
    public Debit(String username,double amount,String description,String type){
        this.username=username;
        this.amount=amount;
        this.description=description;
        this.type=type;
        updateDebit();
    }
    
    
    private void updateDebit(){
        String line="";
        readLastTransactionID();
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath));){
            boolean header = true;
            while ((line = reader.readLine()) != null) {
                if(header){
                    header=false;
                    continue;
                }
                
            String [] columns=line.split(",");
           
            if(columns[0].equals(username)){ // if username is not the target , then loop it again
                    getBalance.add(line);
                }
            else{
                continue;
            }
            } 

            // to find the last balance user hold
            if(!getBalance.isEmpty()){
            int index=getBalance.size()-1;
            String []splitedrow=getBalance.get(index).split(",");
            int balanceIndex=splitedrow.length-1;
            balance=Double.parseDouble(splitedrow[balanceIndex]);
            }
        }catch (IOException ex){
            ex.printStackTrace();
            }      
        
        if(amount<=0){
            lbl=new Label("Cash Amount can't be negative or zero!");
        }
        else{
        balance+=amount;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        lbl=new Label("Succesfully Debited");
        
        transactioninfo = username + "," + transactionID + ","+type+","+amount+"," +description+","+ date + "," + balance;
        transactionID++;
        store(filepath,transactioninfo);
        }
 
    }
    
    public Label getLabel(){
        return lbl;
    }
            
    public void readLastTransactionID() {
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
        boolean header = true;
        while ((line = reader.readLine()) != null) {
            if (header) {
                header = false;
                continue;
            }
            String[] columns = line.split(",");
            if (columns.length > 1) {  // Ensure there are enough columns in the row
           try {
        int lastID = Integer.parseInt(columns[1].trim());  // Parse transaction ID (column 1 should be the ID)
        if (lastID >= transactionID) {
            transactionID = lastID + 1;  // Update transaction ID to the next number
            transactionID=Integer.parseInt(String.format("%08d",transactionID));
        }
    } catch (NumberFormatException e) {
        // If parsing fails, this row is skipped (invalid transaction ID format)
        System.out.println("Invalid transaction ID in row: " + line);
    }
}
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    
   
}