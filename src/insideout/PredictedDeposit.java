package insideout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PredictedDeposit {
   
    private String bank="";
    private String filepath="/Users/cye/NewFolder/InsideOut/src/predictDeposit.csv";
    private String username="";
    private ArrayList<String> lines=new ArrayList<>();
    private double deposit=0.0;
    
   public PredictedDeposit(String bank,String name) {
        this.bank=bank;
        this.username=name;
        update(); // update bank entered by user into csv
        // after updating bank, get the saving
    }
   
    
    public void update(){
        String line;
        int userindex=0;
        boolean depositRecord=true;
            boolean header = true;
            try(BufferedReader reader=new BufferedReader(new FileReader(filepath))){
            while ((line = reader.readLine()) != null) {
                if(header){
                    lines.add(line);
                    header=false;
                    continue;
                }               
               
               String[] column = line.split(",");  // Split the row by commas
               if(!column[0].equals(username)){
                     lines.add(line);
                     continue;
               }
       
       lines.add(line);
       userindex=lines.size()-1;
       StringBuilder fullLine = new StringBuilder(); // This will hold the updated line

       String[] findBank = line.split(",");  // Use the line directly to split
       double savings = Double.parseDouble(findBank[1]);
        calculateDeposit(bank, savings);
        
                if (column.length >= 3) {  
                    column[2] = bank;  
                    for(int i=0;i<column.length;i++){
                        if(i==column.length-1){
                            fullLine.append(column[i]);
                        }
                        else{
                            fullLine.append(column[i]).append(",");
                        }
                    }
                } else {  
                    fullLine.append(column[0]).append(",").append(column[1]).append(",").append(bank);
                }

                fullLine.append(",").append(String.format("%.2f", deposit));

                lines.set(userindex, fullLine.toString());
               
            }
            reader.close();
            writeIntoFile(lines);
            }
        catch (IOException e) {
            // Handle exception if the file is not found or there's an issue reading it
            System.err.println("Error reading the file: " + e.getMessage());
        }
       
   
    }
    
    private void calculateDeposit(String name,double savings){
       double predictedDeposit=0.0;
       switch(bank){
                        case "RHB": predictedDeposit=savings*0.026;break;
                        case "MayBank": predictedDeposit=savings*0.025;break;
                        case "HongLeong": predictedDeposit=savings*0.023;break;
                        case "Alliance": predictedDeposit=savings*0.0285;break;
                        case "Ambank": predictedDeposit=savings*0.0255;break;
                        default: predictedDeposit=savings*0.0265;break;
                    
                    }
       
       deposit=predictedDeposit;
       
   }
    
    public double getDeposit(){
        return deposit;
    }
    
 
    public void writeIntoFile(ArrayList<String> lines){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }       
       writer.close();
    } catch (IOException e) {
        System.err.println("Error writing to the file: " + e.getMessage());
    }
    }
    
}

    