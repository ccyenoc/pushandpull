package insideout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Node;


// for time display 
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;

public class InsideOut extends Application {
    
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final double ASPECT_RATIO = 16.0 / 9.0;
    public static boolean isUser=false;
    public static String Username="";
    
    @Override
    public void start(Stage primaryStage) {
        
// homepage (registration && login page)
        StackPane stackpane = new StackPane();
        AnchorPane homepage = new AnchorPane();
        homepage.setStyle("-fx-background-color: #a8c4f4;");
        whiterec(homepage);
        Button register=new Button("Register"); 
        Button login=new Button("Log In");
        buttonfontsize(register);
        buttonfontsize(login);
        register.setPrefSize(100,35);
        login.setPrefSize(100,35);
        AnchorPane.setTopAnchor(register,300.0);
        AnchorPane.setLeftAnchor(register,200.0);
        AnchorPane.setLeftAnchor(login,400.0);
        AnchorPane.setTopAnchor(login,300.0);
        Label insideout=new Label("Inside Out");
        insideout.setFont(Font.font("Anton", 90)); 
        AnchorPane.setTopAnchor(insideout,50.0);
        AnchorPane.setLeftAnchor(insideout,160.0);
        Scene pagehomepage = new Scene (homepage,700,400);
        pagehomepage.setFill(Color.web("#a8c4f4"));
        
        Image piggybank = new Image("file:/Users/cye/NewFolder/InsideOut/src/piggybank.png"); 
        ImageView piggybankview=new ImageView(piggybank);
        piggybankview.setFitWidth(75);  
        piggybankview.setFitHeight(75); 
        Image money=new Image("file:/Users/cye/NewFolder/InsideOut/src/money.png");
        ImageView moneyview=new ImageView(money);
        moneyview.setFitWidth(75);  
        moneyview.setFitHeight(75); 
        Image moneybag=new Image("file:/Users/cye/NewFolder/InsideOut/src/moneybag.png");
        ImageView moneybagview=new ImageView(moneybag);
        moneybagview.setFitWidth(75);  
        moneybagview.setFitHeight(75); 
        Image coin=new Image("file:/Users/cye/NewFolder/InsideOut/src/coin.png");
        ImageView coinview=new ImageView(coin);
        coinview.setFitWidth(75);  
        coinview.setFitHeight(75); 
      
        piggybankview.setLayoutX(200);
        piggybankview.setLayoutY(200);
        moneyview.setLayoutX(270);
        moneyview.setLayoutY(200);
        moneybagview.setLayoutX(340);
        moneybagview.setLayoutY(200);
        coinview.setLayoutX(410);
        coinview.setLayoutY(200);
        
        
        stackpane.getChildren().addAll(register,login,insideout,piggybankview,moneybagview,moneyview);
        homepage.getChildren().addAll(insideout,register,login,piggybankview,moneybagview,moneyview,coinview);
       
        
// registration page 
        AnchorPane registration=new AnchorPane();
        registration.setStyle("-fx-background-color: #a8c4f4;");
        whiterec(registration);
        Label steps = new Label("STEPS TO REGISTER :");
        steps.setFont(Font.font("Anton", 23)); 
        Label step1 = new Label ("1. ENTER USERNAME BY CLICKING ON "+"\nType your username...");
        step1.setFont(Font.font("Anton", 16)) ;
        Label step2 = new Label ("2. ENTER YOUR EMAIL BY CLICKING ON "+"\nType your email...");
        step2.setFont(Font.font("Anton", 16));
        Label step3 = new Label ("3. ENTER YOUR PASSWORD BY CLICKING ON "+"\nType your password...");
        step3.setFont(Font.font("Anton", 16));
        Label step4 = new Label ("4. CLICK THE Confirm BUTTON BELOW TO SAVE ");
        step4.setFont(Font.font("Anton", 16));
        Label step5=new Label ("5.CLICK THE Log In BUTTON TO LOG IN");
        step5.setFont(Font.font("Anton", 16));
        steps.setLayoutX(360);
        steps.setLayoutY(50);
        step1.setLayoutX(360);
        step1.setLayoutY(85);
        step2.setLayoutX(360);
        step2.setLayoutY(135);
        step3.setLayoutX(360);
        step3.setLayoutY(185);
        step4.setLayoutX(360);
        step4.setLayoutY(235);
        step5.setLayoutX(360);
        step5.setLayoutY(263);
        Label registrationtitle=new Label("REGISTRATION");
        registrationtitle=header(registrationtitle,registration);
        
           // registration guidelines
        yellowrec(registration);
        
        Button tologinpage=new Button("Confirm");
        buttonfontsize(tologinpage);
        tologinpage.setLayoutX(400);
        tologinpage.setLayoutY(300);
        tologinpage.setPrefSize(100,18);
        
        
        // method call
        Label username=instruction(100,"username");
        TextField inputusername= input("Enter your username :","username", 100.0 , 50.0);
        Label email=instruction(180,"email");
        TextField inputemail= input("Enter your email :","email",180.0 ,50.0);
        Label password=instruction(260,"password");
        TextField inputpassword =input("Enter your password:","password", 270.0 , 50.0);
        
        String[] registername={""};
        inputusername.textProperty().addListener((observable, oldValue, newValue) -> {
             registername[0] = newValue.trim();}); 
        String [] registeremail={""};
        inputemail.textProperty().addListener((observable, oldValue, newValue) -> {
            registeremail[0] = newValue.trim();}); 
        String[] registerpassword={""};
        inputpassword.textProperty().addListener((observable, oldValue, newValue) -> {
             registerpassword[0] = newValue.trim();}); 
        
        
        stackpane.getChildren().add(tologinpage);      
        registration.getChildren().addAll(inputusername,inputpassword,inputemail,tologinpage,steps,step1,step2,step3,step4,step5
        ,registrationtitle,username,email,password);
        Scene pageregistration=new Scene (registration,700,400);
        pageregistration.setFill(Color.web("#a8c4f4"));
        
// log in page
        AnchorPane logIn=new AnchorPane();
        whiterec(logIn);
        logIn.setStyle("-fx-background-color: #a8c4f4;");
        Label logintitle=new Label("LOG IN");
        logintitle=header(logintitle,logIn);
        Button loginbtn=new Button("Log In");
        buttonfontsize(loginbtn);
        AnchorPane.setTopAnchor(loginbtn,300.0);
        AnchorPane.setLeftAnchor(loginbtn,400.0);
        
        // method call
        username=instruction(100,"username");
        TextField loginusername=input("Enter your username :","username", 100.0 , 50.0);
        email=instruction(180,"email");
        TextField loginemail=input("Enter your email :","email",180.0 ,50.0);
        password=instruction(260,"password");
        TextField loginpassword =input("Enter your password:","password", 270.0 , 50.0);
        Scene pagelogin=new Scene(logIn,700,400);
        pagelogin.setFill(Color.web("#a8c4f4"));

        String[] name = {""};
        loginusername.textProperty().addListener((observable, oldValue, newValue) -> {
             name[0] = newValue.trim();}); 

        String[] useremail = {""};
        loginemail.textProperty().addListener((observable, oldValue, newValue) -> {
              useremail[0] = newValue.trim();});

        String[] userpassword={""};
        loginpassword.textProperty().addListener((observable, oldValue, newValue) -> {
              userpassword[0] = newValue.trim();});

        logIn.getChildren().addAll(loginbtn,username,loginusername,loginpassword,password,loginemail,email,logintitle);
        
// main page
        AnchorPane mainPage=new AnchorPane();
        whiterec(mainPage);
        Scene pagemainPage= new Scene (mainPage,700,400);
        pagemainPage.setFill(Color.web("#a8c4f4"));
        mainPage.setStyle("-fx-background-color: #a8c4f4;");
        currenttime(mainPage);
        Button debitbtn =new Button ("Debit");
        Button creditbtn=new Button("Credit");        
        Button savingbtn=new Button("Savings");       
        Button historybtn=new Button("History");       
        Button creditloanbtn=new Button("Credit Loan");       
        Button interestpredictorbtn=new Button("Deposit Interest Predictor");       
        Button logoutbtn=new Button("Log Out");
        mainpagebtn(debitbtn,260,20,213,75);
        mainpagebtn(creditbtn,260,20,213,365);
        mainpagebtn(savingbtn,260,20,258,75);
        mainpagebtn(historybtn,260,20,258,365);
        mainpagebtn(creditloanbtn,260,20,303,75);
        mainpagebtn(interestpredictorbtn,260,20,303,365);
        
        Rectangle menu = new Rectangle(607,150);  // Width, Height
        menu.setFill(Color.web("#FEEBA8"));  // Fill the rectangle with blue color
        menu.setArcWidth(20);     // Horizontal radius of the corner
        menu.setArcHeight(20);    // Vertical radius of the corner
        menu.setLayoutX(45);
        menu.setLayoutY(200);
        
        Label welcome=new Label("Welcome ");// get username afterward
        welcome=header(welcome,mainPage);
        welcome.setFont(Font.font("Anton", 60));
        mainPage.getChildren().addAll(menu,welcome,debitbtn,creditbtn,historybtn,creditloanbtn,interestpredictorbtn,logoutbtn,savingbtn); 
        
// debit page
         AnchorPane debit=new AnchorPane();
         Scene pagedebit=new Scene(debit,700,400);
         debit.setStyle("-fx-background-color: #a8c4f4;");
         whiterec(debit);
         pagedebit.setFill(Color.web("#a8c4f4"));
         Label debittitle= new Label("Debit");
         debittitle=header(debittitle,debit);
         Label amountinstruction=instruction(100,"Debit Amount");
         Label descriptioninstruction=instruction( 160,"Description");     
         
         // to enter amount of debit
        // Create the TextField for amount debit
        TextField amountdebit = input("Enter Debit Amount:", "Debit Amount", 100.0, 50.0);
        TextArea descriptiond = description("Enter Description:", "Description", 185.0, 50.0);

        String[] descriptiondstr = {""};
        descriptiond.textProperty().addListener((observable, oldValue, newValue) -> {
        descriptiondstr[0] = newValue; // Update the description dynamically as user types
        });


        Button confirmdebit = new Button("Confirm");
        confirmdebit.setStyle("-fx-background-color:#FED760;-fx-text-fill:black;");
        confirmdebit.setFont(Font.font("Anton", 20)); 
        confirmdebit.setLayoutX(500);
        confirmdebit.setLayoutY(300);

       confirmdebit.setOnAction(e -> {
       final String input = amountdebit.getText(); // Get the text entered by the user in amountdebit TextField
       try{
          double debitamount =Double.parseDouble(input); 
          Debit(debitamount, descriptiondstr[0], "Debit");
          Label debitsuccesful=new Label("Succesfully Dedited");
          popupMessage(debitsuccesful);
          
       }catch(Exception ex){
           Label wrongcashformat=new Label("Wrong Cash Format eg.1000");
           popupMessage(wrongcashformat);
           ex.printStackTrace();
       }
         });



         
         ImageView piggybankdebit=new ImageView(piggybank);
         piggybankdebit.setLayoutX(150);
         piggybankdebit.setLayoutY(40);
         piggybankdebit.setFitWidth(50);
         piggybankdebit.setFitHeight(50);
         ImageView coindebit=new ImageView(coin);
         coindebit.setLayoutX(185);
         coindebit.setLayoutY(42);
         coindebit.setFitWidth(60);
         coindebit.setFitHeight(60);
         
         
         // to main page
     
         // to credit page
         // to history page
         // to saving page
         // to credit loan page
         // to predicted deposit page
         // log out
         
         debit.getChildren().addAll(confirmdebit,amountdebit,descriptiond,debittitle,amountinstruction,descriptioninstruction,piggybankdebit,coindebit);
      
         
// credit page
         AnchorPane credit=new AnchorPane();
         Scene pagecredit=new Scene(credit,700,400);
         credit.setStyle("-fx-background-color: #a8c4f4;");
         whiterec(credit);
         pagecredit.setFill(Color.web("#a8c4f4"));
         Label credittitle= new Label("Credit");
         credittitle=header(credittitle,credit);
         amountinstruction=instruction(100,"Credit Amount");
         descriptioninstruction=instruction( 160,"Description");     
         
         // to enter amount of debit/credit
        TextField amountcredit = input("Enter Debit Amount:", "Debit Amount", 100.0, 50.0);
        TextArea descriptionc = description("Enter Description:", "Description", 185.0, 50.0);

        String[] descriptioncstr = {""};
        descriptionc.textProperty().addListener((observable, oldValue, newValue) -> {
        descriptioncstr[0] = newValue; // Update the description dynamically as user types
        });


       Button confirmcredit = new Button("Confirm");
       confirmcredit.setOnAction(e -> {
       final String input = amountcredit.getText(); // Get the text entered by the user in amountdebit TextField
       try{
          double creditamount =Double.parseDouble(input); 
          Credit(creditamount, descriptioncstr[0], "Credit");
          Label creditsuccesful=new Label("Succesfully Credited");
          popupMessage(creditsuccesful);
          
       }catch(Exception ex){
           Label wrongcashformat=new Label("Wrong Cash Format eg.1000");
           popupMessage(wrongcashformat);
           ex.printStackTrace();
       }
         });
         credit.getChildren().addAll(amountcredit,descriptionc,credittitle,amountinstruction,descriptioninstruction,confirmcredit);
         
// history page
        AnchorPane history=new AnchorPane();
        Scene pagehistory=new Scene (history,700,400);
        history.setStyle("-fx-background-color: #a8c4f4;");
        whiterec(history);
        pagehistory.setFill(Color.web("#a8c4f4"));
        Label historytitle=new Label();
        historytitle=header(historytitle,history);
        
       
        history.getChildren().addAll(historytitle);
        
// saving page
        AnchorPane saving=new AnchorPane();
        Scene pagesaving=new Scene(saving,700,400);
        saving.setStyle("-fx-background-color: #a8c4f4;");
        whiterec(saving);
        pagesaving.setFill(Color.web("#a8c4f4"));
        Label savingtitle=new Label("Saving");
        savingtitle=header(savingtitle,saving);
        
        
        saving.getChildren().addAll(savingtitle);
        
// credit loan page
         AnchorPane creditloan=new AnchorPane();
         Scene pagecreditloan=new Scene(creditloan,700,400);
         creditloan.setStyle("-fx-background-color: #a8c4f4;");
         whiterec(creditloan);
         pagecreditloan.setFill(Color.web("#a8c4f4"));
         Label creditloantitle=new Label("Credit Loan");
         creditloantitle=header(creditloantitle,creditloan);
         
         creditloan.getChildren().addAll(creditloantitle);
         
// predited deposit page
        AnchorPane predicteddeposit=new AnchorPane();
        Scene pagedeposit=new Scene(predicteddeposit,700,400);
        predicteddeposit.setStyle("-fx-background-color: #a8c4f4;");
        whiterec(predicteddeposit);
        pagecreditloan.setFill(Color.web("#a8c4f4"));
        Label deposittitle=new Label("Predicted Deposit");
        deposittitle=header(deposittitle,predicteddeposit);
        Label bank=new Label("Bank :");
        bank.setLayoutX(50);
        bank.setLayoutY(100);
        bank.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill: black; -fx-border-radius: 5px;");
        bank.setFont(Font.font("Anton", 23));  // Set the font family and size here
        
        
        bankSelection(predicteddeposit);
        
        Button arrow=new Button("↓");
        arrow.setLayoutX(250);
        arrow.setLayoutY(150);
        arrow.setOnAction(e->showBankSelection(predicteddeposit));
        
        TextArea displayDeposit = new TextArea();
        displayDeposit.setEditable(false); // Make it read-only
        displayDeposit.setWrapText(true);
        displayDeposit.setLayoutX(50);
        displayDeposit.setLayoutY(100);
        displayDeposit.setPrefWidth(200);
        displayDeposit.setPrefHeight(100); // Adjust height as nee
        Button displayPredictedDepositbtn=new Button("Calculate Predicted Deposit");
        
           
        
        
        predicteddeposit.getChildren().addAll(deposittitle,arrow,bank);
       
        submenu(primaryStage,debit,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
        submenu(primaryStage,credit,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
        submenu(primaryStage,history,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
        submenu(primaryStage,saving,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
        submenu(primaryStage,creditloan,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
        submenu(primaryStage,predicteddeposit,pagehomepage,pagedebit,pagecredit,pagesaving,pagehistory,pagecreditloan,pagedeposit);
       
        
// button action (navigation,setScene)
        primaryStage.setScene(pagehomepage);
        register.setOnAction(e-> primaryStage.setScene(pageregistration)); // to registration page
        login.setOnAction(e-> primaryStage.setScene(pagelogin)); // homepage to log in page
        tologinpage.setOnAction(e->{
                register(registername[0],registeremail[0],registerpassword[0]);
                if(registrationValid==true){
                primaryStage.setScene(pagelogin);}
        }); // registration to log in page
        loginbtn.setOnAction(e-> {
          logIn(name[0], useremail[0], userpassword[0]);
          if(isUser==true){
            primaryStage.setScene(pagemainPage);}
                }); //from login to mainpage
        debitbtn.setOnAction(e-> primaryStage.setScene(pagedebit));
        creditbtn.setOnAction(e->primaryStage.setScene(pagecredit));
        historybtn.setOnAction(e->primaryStage.setScene(pagehistory));
        savingbtn.setOnAction(e->primaryStage.setScene(pagesaving));
        interestpredictorbtn.setOnAction(e->primaryStage.setScene(pagedeposit));
        
        primaryStage.setTitle("InsideOut");
        primaryStage.show();
        // Add listener to maintain aspect ratio
        primaryStage.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double newHeight = newWidth.doubleValue() / ASPECT_RATIO;
            primaryStage.setHeight(newHeight);
        });

        primaryStage.heightProperty().addListener((obs, oldHeight, newHeight) -> {
            double newWidth = newHeight.doubleValue() * ASPECT_RATIO;
            primaryStage.setWidth(newWidth);
        });

        primaryStage.show();
        Image icon = new Image("file:/Users/cye/NewFolder/InsideOut/src/insideout/insideoutlogo.png"); 
        primaryStage.getIcons().add(icon);
        
       
       
    }
   
 
// method(s)

// decorations
    
    public void whiterec(AnchorPane pane){
        Rectangle whiterec = new Rectangle(635,335);  // Width, Height
        whiterec.setFill(Color.WHITE);  // Fill the rectangle with blue color
        whiterec.setArcWidth(20);     // Horizontal radius of the corner
        whiterec.setArcHeight(20);    // Vertical radius of the corner
        AnchorPane.setTopAnchor(whiterec,30.0);
        AnchorPane.setLeftAnchor(whiterec,30.0);
        pane.getChildren().add(whiterec);
    }
    
    public void yellowrec(AnchorPane pane){
        Rectangle yellowrec = new Rectangle(320,300);  // Width, Height
        yellowrec.setFill(Color.web("#FEEBA8"));  // Fill the rectangle with blue color
        yellowrec.setArcWidth(20);     // Horizontal radius of the corner
        yellowrec.setArcHeight(20);    // Vertical radius of the corner
        AnchorPane.setTopAnchor(yellowrec,45.0);
        AnchorPane.setLeftAnchor(yellowrec,325.0);
        pane.getChildren().add(yellowrec);
    }
    
    public Label header(Label label,AnchorPane pane){
        Label header=label;
        label.setLayoutX(50);
        label.setLayoutY(30);
        label.setFont(Font.font("Anton", 45));
        return header;
    }
    
    // yellow button
    public void buttonfontsize(Button button){
        button.setStyle("-fx-background-color:#FED760;-fx-text-fill:black;");
        button.setFont(Font.font("Anton", 20)); 
    }
    
    // button
        public void mainpagebtn(Button button, double width, double height, double topAnchor, double leftAnchor) {
        button.setStyle("-fx-background-color:#FED760;-fx-text-fill:black;");
        button.setFont(Font.font("Anton", 15));
        button.setPrefSize(260,20);
        
        button.setPrefSize(width, height); 
        AnchorPane.setTopAnchor(button, topAnchor); 
        AnchorPane.setLeftAnchor(button, leftAnchor); 
    }
        public void submenubtn(Button button, double width, double height, double topAnchor, double leftAnchor) {
        button.setStyle("-fx-background-color:#fff8e3;-fx-text-fill:black;");
        button.setFont(Font.font("Anton", 15));
        button.setPrefSize(260,20);
        
        button.setPrefSize(width, height); 
        AnchorPane.setTopAnchor(button, topAnchor); 
        AnchorPane.setLeftAnchor(button, leftAnchor); 
    }
 
        public static Label currenttime(AnchorPane pane) {
        Label time = new Label();  // display the time
        time.setFont(Font.font("Anton", 70)); 
        time.setLayoutX(410);
        time.setLayoutY(20);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timeline timeline = new Timeline(  // control the time
            new KeyFrame(Duration.seconds(1), event -> {
                String currentTime = LocalTime.now().format(timeFormatter);
                time.setText(currentTime);
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
       

        pane.getChildren().add(time);
        return time;
    }
        
    
// input 
    public TextField input(String text,String type,double top,double left){
        // create label
        Label label = new Label(text);
        label.setFont(Font.font("Anton", 15));
        AnchorPane.setTopAnchor(label, top);
        AnchorPane.setLeftAnchor(label, left);
        
        // user input section
        TextField textField = new TextField();
        textField.setPromptText("Type your "+type+" here...");
        textField.setPrefColumnCount(19);
        textField.setStyle("-fx-font-size: 14px; -fx-background-color:#FFFFFF ;-fx-text-fill: black; -fx-border-radius: 5px;");
        textField.setFont(Font.font("Anton", 12));
        AnchorPane.setTopAnchor(textField, top + 25);
        AnchorPane.setLeftAnchor(textField, left);

        // line
        Line line = new Line(left, top + 55, left + 230, top + 55); // Adjust the length of the line
        line.setStroke(Color.BLACK);

        // Add label and line to the AnchorPane (not returned, but you can add them in your main method)
        return textField;
        
    }
   
 
    public Label instruction(int inputY,String type){
        Label instruction=new Label("Enter your "+type+":");
        instruction.setFont(Font.font("Anton", 15));
        instruction.setLayoutX(50);
        instruction.setLayoutY(inputY);
        return instruction;
    }
    
    public TextArea description(String text,String type,double top,double left){
        Label label = new Label(text); // to display Enter your text :
        label.setFont(Font.font("Anton", 15));
        AnchorPane.setTopAnchor(label, top);
        AnchorPane.setLeftAnchor(label, left);
        
        // user input section
        TextArea area = new TextArea();
        area.setPromptText("Type your "+type+" here..."); // to display Type your type here ... section
        area.setPrefWidth(400);  // Set the preferred width
        area.setPrefHeight(160);  
        area.setWrapText(true); // this ensures when text type exceed the width of textarea thn the text will be displayed at the nxt line
        area.setStyle("-fx-font-size: 15px; -fx-background-color:#FFFFFF ; -fx-text-fill: black; -fx-border-radius: 5px;");
        area.setFont(Font.font("Anton", 12));
        AnchorPane.setTopAnchor(area, top);
        AnchorPane.setLeftAnchor(area, left);

        // line
        Line line = new Line(left, top + 55, left + 230, top + 55); // Adjust the length of the line
        line.setStroke(Color.BLACK);

        // Add label and line to the AnchorPane (not returned, but you can add them in your main method)
        return area;
    }
    
     
 // navigation methods
    
    public void submenu(Stage primaryStage,AnchorPane pane,Scene homepage, Scene debit,Scene credit,Scene saving,Scene history,Scene creditloan,Scene deposit){
        Rectangle yellowrec = new Rectangle(240,335);  // Width, Height
        yellowrec.setFill(Color.web("#f4d2d2"));  // Fill the rectangle with blue color
        yellowrec.setArcWidth(20);     // Horizontal radius of the corner
        yellowrec.setArcHeight(20);    // Vertical radius of the corner
        AnchorPane.setTopAnchor(yellowrec,30.0);
        AnchorPane.setLeftAnchor(yellowrec,425.0);
        pane.getChildren().add(yellowrec);
        
        Button submenu=new Button("☰");
        submenu.setStyle("-fx-background-color:#FEEBA8;-fx-text-fill:black;");
        submenu.setFont(Font.font("Anton", 15));
        submenu.setLayoutX(600);
        submenu.setLayoutY(42);
        submenu.setPrefWidth(35);
        submenu.setPrefHeight(35);
        
        submenu.setOnAction(e -> showSubmenu(pane));
   

        pane.getChildren().add(submenu);
        
        Button debitbtn =new Button ("Debit");
        Button creditbtn=new Button("Credit");        
        Button savingbtn=new Button("Savings");       
        Button historybtn=new Button("History");       
        Button creditloanbtn=new Button("Credit Loan");       
        Button interestpredictorbtn=new Button("Deposit Interest Predictor");       
        Button logoutbtn=new Button("Log Out");
        submenubtn(debitbtn,190,20,85,455);  // just for color and coordinate
        submenubtn(creditbtn,190,20,125,455); 
        submenubtn(savingbtn,190,20,165,455); 
        submenubtn(historybtn,190,20,205,455); 
        submenubtn(creditloanbtn,190,20,245,455); 
        submenubtn(interestpredictorbtn,190,20,285,455); 
        submenubtn(logoutbtn,190,20,325,452); 
        logoutbtn.setStyle("-fx-background-color:#FEEBA8;-fx-text-fill:black;");
        debitbtn.setVisible(false);
        creditbtn.setVisible(false);
        savingbtn.setVisible(false);
        historybtn.setVisible(false);
        creditloanbtn.setVisible(false);
        interestpredictorbtn.setVisible(false);
        logoutbtn.setVisible(false);
        yellowrec.setVisible(false);
        
        debitbtn.setManaged(false);
        creditbtn.setManaged(false);
        savingbtn.setManaged(false);
        historybtn.setManaged(false);
        creditloanbtn.setManaged(false);
        interestpredictorbtn.setManaged(false);
        logoutbtn.setManaged(false);
        yellowrec.setManaged(false);
        
        debitbtn.getStyleClass().add("submenu");
        creditbtn.getStyleClass().add("submenu");
        savingbtn.getStyleClass().add("submenu");
        historybtn.getStyleClass().add("submenu");
        creditloanbtn.getStyleClass().add("submenu");
        interestpredictorbtn.getStyleClass().add("submenu");
        logoutbtn.getStyleClass().add("submenu");
        yellowrec.getStyleClass().add("submenu");
        

        pane.getChildren().addAll(debitbtn, creditbtn, savingbtn, historybtn, creditloanbtn, interestpredictorbtn, logoutbtn);

        debitbtn.setOnAction(e -> primaryStage.setScene(debit));
        creditbtn.setOnAction(e -> primaryStage.setScene(credit));
        savingbtn.setOnAction(e -> primaryStage.setScene(saving));
        historybtn.setOnAction(e -> primaryStage.setScene(history));
        creditloanbtn.setOnAction(e -> primaryStage.setScene(creditloan));
        interestpredictorbtn.setOnAction(e -> primaryStage.setScene(deposit));
        logoutbtn.setOnAction(e -> primaryStage.setScene(homepage)); // For example, go back to Page 1 when "Log Out" is clicked
        
 
    }
    
    public void showSubmenu(AnchorPane pane) {
    // Find all buttons added to the pane
    for (javafx.scene.Node node : pane.getChildren()) {
         if (node.getStyleClass().contains("submenu")) {
            node.setVisible(!node.isVisible()); // Toggle visibility
            node.setManaged(!node.isManaged()); // Toggle layout inclusion
        }
    }
    } 
    
    private String selectedBank=""; // it should be static as
    
    public void bankSelection(AnchorPane pane){
        
        
       Label instruction = new Label("Select Your Bank");
       instruction.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill: black; -fx-border-radius: 5px;");
       instruction.setFont(Font.font("Anton", 23));  // Set the font family and size here
       instruction.setLayoutX(50);
       instruction.setLayoutY(130);

        // button to click 
        Button RHB =new Button("RHB");
        bankSelectionbtn(RHB,50,170,5,160);
        Button MayBank=new Button("MayBank");
        bankSelectionbtn(MayBank,50,210,5,160);
        Button HongLeong=new Button("Hong Leong");
        bankSelectionbtn(HongLeong,50,250,5,160);
        Button Alliance=new Button("Alliance");
        bankSelectionbtn(Alliance,50,290,5,160);
        Button AmBank=new Button("AmBank");
        bankSelectionbtn(AmBank,50,330,5,160);
        Button StandardChartered=new Button("Standard Chartered");
        bankSelectionbtn(StandardChartered,50,370,5,160);   
        Button confirmbtn=new Button("Confirm");
        confirmbtn.setStyle("-fx-background-color:#FEEBA8;-fx-text-fill:black;");
        confirmbtn.setFont(Font.font("Anton", 15));
        confirmbtn.setLayoutX(300);
        confirmbtn.setLayoutY(150);
        
        // to show user bank
        Label rhblbl=new Label("RHB");
        rhblbl.setVisible(false);
        rhblbl.setManaged(false);
        Label maybanklbl=new Label("MayBank");
        maybanklbl.setVisible(false);
        maybanklbl.setManaged(false);
        Label hongleonglbl=new Label ("Hong Leong");
        hongleonglbl.setVisible(false);
        hongleonglbl.setManaged(false);
        Label alliancelbl=new Label("Alliance");
        alliancelbl.setVisible(false);
        alliancelbl.setManaged(false);
        Label ambanklbl=new Label("AmBank");
        ambanklbl.setVisible(false);
        ambanklbl.setManaged(false);
        Label standardcharteredlbl=new Label("Standard Chartered");
        standardcharteredlbl.setVisible(false);
        standardcharteredlbl.setManaged(false);
        
        // bg of the button
        Rectangle bankselectionBG=new Rectangle();
        bankselectionBG.setFill(Color.web("#f4d2d2"));  // Fill the rectangle with blue color
        bankselectionBG.setArcWidth(20);     // Horizontal radius of the corner
        bankselectionBG.setArcHeight(20);    // Vertical radius of the corner
        bankselectionBG.setLayoutX(40);
        bankselectionBG.setLayoutY(250);
        
       // adding nodes into style class so that can control its visibility 
        RHB.getStyleClass().add("bankSelection");
        MayBank.getStyleClass().add("bankSelection");
        HongLeong.getStyleClass().add("bankSelection");
        Alliance.getStyleClass().add("bankSelection");
        AmBank.getStyleClass().add("bankSelection");
        StandardChartered.getStyleClass().add("bankSelection");
        
        Label depositLabel = new Label("Predited Deposit :");
        
        
        
        RHB.setOnAction(e -> { 
        label(rhblbl);
        instruction.setVisible(false); 
        selectedBank="RHB";
        });
        MayBank.setOnAction(e -> { 
        label(maybanklbl); 
        showBankSelection(pane); 
        instruction.setVisible(false);
        selectedBank="MayBank";
        });
        HongLeong.setOnAction(e -> { 
        label(hongleonglbl);
        instruction.setVisible(false); 
        selectedBank="HongLeong";
        });
        Alliance.setOnAction(e -> { 
        label(alliancelbl);
        instruction.setVisible(false);
        selectedBank="Allaince";
        });
        AmBank.setOnAction(e -> { 
        label(ambanklbl);
        instruction.setVisible(false); 
        selectedBank="AmBank";
        });
        StandardChartered.setOnAction(e -> { 
        label(standardcharteredlbl);
        instruction.setVisible(false); 
        selectedBank="StandardChartered";
        });
        
        confirmbtn.setOnAction(c -> {
        if (selectedBank != null) {
            // Perform calculation and update the label
            depositCalculator(selectedBank, depositLabel, pane);
        } else {
            depositLabel.setText("Please select a bank first!");
        }
    });
        
  
        
        pane.getChildren().addAll(confirmbtn,bankselectionBG,RHB,MayBank,HongLeong,Alliance,AmBank,StandardChartered,instruction,rhblbl,maybanklbl,hongleonglbl,alliancelbl,ambanklbl,standardcharteredlbl);
        
    }
    
    public void bankSelectionbtn(Button btn,double x,double y,double height,double width){
        btn.setStyle("-fx-background-color:#FEEBA8;-fx-text-fill:black;");
        btn.setFont(Font.font("Anton", 15));
        btn.setPrefSize(height,width);
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setVisible(true);
        btn.setManaged(true);
        btn.toFront();
    }
    
    public void setLabelVisibility(Label label) {
    label.setVisible(false);
    label.setManaged(false);  // Initially set the label to not be visible or managed
    }
    
    public void label(Label label){
       label.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill: black; -fx-border-radius: 5px;");
       label.setFont(Font.font("Anton", 23));  // Set the font family and size here
       label.setLayoutX(100);
       label.setLayoutY(150);
       label.setVisible(true);
       label.setManaged(true);
    }
    
    public void showBankSelection(AnchorPane pane) {
    // Find all buttons added to the pane
    for (javafx.scene.Node node : pane.getChildren()) {
         if (node.getStyleClass().contains("bankSelection")) {
            node.setVisible(!node.isVisible()); 
            node.setManaged(!node.isManaged()); 
        }
        
    }
    } 
    

// functions
// log in page
    public static String userinfo="/Users/cye/NewFolder/InsideOut/src/userinfo - Sheet1.csv";
    public static void logIn(String name,String email,String password){
       String userfullinfo="";
       String line="";
       boolean foundUser=false;
       try(BufferedReader reader=new BufferedReader(new FileReader(userinfo))){
           boolean header=true;
           found:{
           while((line=reader.readLine())!=null){
               if (header) {
                header = false;
                continue;
            }
              String findUser[]=line.split(",");
              if(name.equals(findUser[0]) && password.equals(findUser[3]) && email.equals(findUser[2])){
                       Username=name;
                       isUser=true;
                       Label welcomeuser=new Label("Welcome to InsideOut!");
                       foundUser=true;
                       popupMessage(welcomeuser);
                       break found;
                }
           }
               if(foundUser==false){
               Label usernotfound=new Label("User Not Found!");
               popupMessage(usernotfound);   
  
           }
           
           }
           }catch (IOException ex){
                 ex.printStackTrace();
           }
        
       
    }  
   
// registration page
    static boolean registrationValid=false;
    public static void register(String username,String email,String password){
        String line="";
        String newUserInfo="";
        boolean header=true;
        int lineIndex=0;
        ArrayList<String> lines=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(userinfo))){
            userFound:{
            while((line=reader.readLine())!=null){ // to check if there is exist user and username taken
                if(header==true){
                    header=false;
                    lines.add(line);
                    continue;
                }
                
                String checkUser[]=line.split(",");
                for(int i=0;i<checkUser.length;i++){
                    if(checkUser[1].equals(email)){ // check whether user exists
                        Label userexist=new Label("User Exist!");
                        popupMessage(userexist);
                        break userFound;
                    }
                    else if(checkUser[0].equals(username)){ // check if username taken
                        Label usernameexist=new Label("Username Taken!");
                        popupMessage(usernameexist);
                        break userFound;
                    }}
                lineIndex++;   
                lines.add(line);
            }
            
            // generate userID
            String []findLastID=lines.get(lineIndex).split(",");
            // id without IO
            String[] numID=findLastID[1].split("");
            String ID="";
            for(int i=2;i<numID.length;i++){
                ID+=numID[i];
            }
            int lastID=Integer.parseInt(ID);
            int newID=lastID+1;
            String userID="IO"+String.format("%7s",newID).replace(" ","0");           
            
                    // when it is a new user and username is unique, check password and email format
                    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    boolean validEmail = Pattern.matches(emailRegex, email);
                    if((password.length()<8) || (password.matches("[A-Z]+")) || password.matches("[a-z]+")){ // check if password hits requirement
                        Label enhancePassword=new Label("Enter a Strong Password!");
                        popupMessage(enhancePassword);
                        break userFound;
                    }
                    else if(validEmail==false){
                        Label emailInvalid=new Label("Invalid Email !");
                        popupMessage(emailInvalid);
                        break userFound;
                    }
                    
                    registrationValid=true;
                    if(registrationValid==true){
                     newUserInfo=username+","+userID+","+email+","+password;
                     store(userinfo,newUserInfo);
                    }
        }
             
        }
        catch(IOException ex){
                ex.printStackTrace();
    }
        
    }
// record debit and credit
    static void store(String file,String content) {
        String line;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));

            bw.newLine();
            bw.write(content);
        }
        catch(IOException e){
            e.printStackTrace();

        }
        finally {
            
             try {
                if (bw != null) {
                    bw.close(); // Close BufferedWriter
                }
            }
            catch (IOException e ){

                e.printStackTrace();
            }

        }
    }

    static String filepath = "/Users/cye/NewFolder/InsideOut/src/recorddebitandcredit - Sheet1.csv";
    static String transactioninfo="";
    static int transactionID=1;
    static double balance=0.0;
    
    static void readLastTransactionID() {
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

    static ArrayList<String> getBalance=new ArrayList<>();
    static void Debit(double amount,String description,String type){
        String username=Username;
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
           
            if(!columns[0].equals(username)){ // if username is not the target , then loop it again
                    getBalance.add(line);
                    continue; // continue with the next row when it is not the target user
                }
            } 
            
            getBalance.add(line);
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
        
        balance+=amount;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");

        
        transactioninfo = username + "," + transactionID + ","+type+","+amount+"," +description+","+ date + "," + balance;
        transactionID++;
        store(filepath,transactioninfo);
    }
    
    static void Credit(double amount,String description,String type){
        String username=Username;
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
                    continue; // continue with the next row when it is not the target user
                }
            } 
            
            // to find the last balance user hold
            if(!getBalance.isEmpty()){
            int index=getBalance.size()-1;
            String []splitedrow=getBalance.get(index).split(",");
            int balanceIndex=splitedrow.length-1;
            balance=Double.parseDouble(splitedrow[balanceIndex]);
            }
            getBalance.clear();
        }catch (IOException ex){
            ex.printStackTrace();
            }      
        
        balance-=amount;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");

        
        transactioninfo = username + "," + transactionID + ","+type+","+amount+"," +description+","+ date + "," + balance;
        transactionID++;
        store(filepath,transactioninfo);
    }
    
// predicted deposit
    static String predictedDepositfilepath= "/Users/cye/NewFolder/InsideOut/src/predictDeposit.csv";
    static BufferedReader reader=null;
    static BufferedWriter writer=null;
       
    public void depositCalculator(String bank,Label showDeposit,AnchorPane pane){
        ArrayList<String> lines = new ArrayList<>(); // lines(form username to predicted deposit)
        double predictedDeposit=0.0;
        int userindex=0;
       
       // csv file is updated with bank so that calculation can be performed
       try {
            String targetUsername=Username; // example 
            String line;
            boolean header = true;
            BufferedReader reader=new BufferedReader(new FileReader(predictedDepositfilepath));
            while ((line = reader.readLine()) != null) {
                if(header){
                    lines.add(line);
                    header=false;
                    continue;
                }
                
            String [] columns=line.split(",");
         
            if(!columns[0].equals(targetUsername)){ // if username is not the target , then loop it again
                    lines.add(line); // to add all line into it
                    continue; // continue with the next row when it is not the target user
                }
            
            // when target user found
                lines.add(line); // add targetuser row into the list
                userindex=lines.size()-1; // index of the target user (row)  
            
                String[] column = lines.get(userindex).split(","); // split the row by , and store them in an array
                String fullLine="";
                
                if(column.length>=2){ // if previously there is bank in csv file 
                    column[2]=bank;  // replaced it
                    for(int i=0;i<column.length;i++){
                        if(i==column.length-1){
                            fullLine+=column[i];
                        }
                        else{
                            fullLine+=column[i]+",";
                        }}
                }
                else{  // no bank record in csv file
                 fullLine=line+","+bank; // concate the bank with ori line
                }
                
                // String bankName = fullLine.split(",")[2];  // Get bank name
                 String[] findBank = fullLine.split(","); // Parse the current state of the full line
                 boolean depositRecord=true;
                 if(findBank.length>=3){
                     depositRecord=true;
                 }
                 else{
                     depositRecord=false;
                 }
                 
                 String bankName = findBank[2]; // Bank name (already updated or appended earlier)
                 double savings = Double.parseDouble(findBank[1]); // Extract savings
                 predictedDeposit = predictDeposit(bankName, savings); // Calculate predicted deposit

                 StringBuilder updatedLine = new StringBuilder();
                 if(depositRecord==true){ // if it has previous record
                     findBank[3]=String.valueOf(predictedDeposit); // replace it with the latest predicted deposit
                     for(int i=0;i<findBank.length;i++){
                         if(i==findBank.length-1){
                             updatedLine.append(findBank[i]);
                             break;
                         }
                         updatedLine.append(findBank[i]).append(",");
                     }
                 }
                 else{ // new user
                   for(int i=0;i<findBank.length;i++){
                       if(i==findBank.length-1){
                           updatedLine.append(findBank[i]);
                           break;
                       }
                       updatedLine.append(findBank[i]).append(",");
                   }
                 updatedLine.append(",").append(String.format("%.2f", predictedDeposit));
                 }
                 
                 lines.set(userindex, updatedLine.toString());
               
            }
            reader.close();
            }
        catch (IOException e) {
            // Handle exception if the file is not found or there's an issue reading it
            System.err.println("Error reading the file: " + e.getMessage());
        } 
       
       // thisp part is extremely neccessary as it is acutually rewriting the entire csv file one line by one line
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(predictedDepositfilepath))) {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        
       writer.close();
    } catch (IOException e) {
        System.err.println("Error writing to the file: " + e.getMessage());
    }

    showDeposit.setText("RM " + String.format("%.2f", predictedDeposit));
    showDeposit.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill: black; -fx-border-radius: 5px;");
    showDeposit.setFont(Font.font("Anton", 23));  // Set the font family and size here
    showDeposit.setLayoutX(50);
    showDeposit.setLayoutY(260);
    
    if (!pane.getChildren().contains(showDeposit)) {
    pane.getChildren().add(showDeposit);// Add the button only if it's not already in the parent
    }
    else{
        pane.getChildren().remove(showDeposit);
        pane.getChildren().add(showDeposit);
    }
    
}

    
     public static double predictDeposit(String bankName,double savings){
      double predictedDeposit=0.0;
      switch(bankName){
                        case "RHB": predictedDeposit=savings*0.026;break;
                        case "MayBank": predictedDeposit=savings*0.025;break;
                        case "HongLeong": predictedDeposit=savings*0.023;break;
                        case "Alliance": predictedDeposit=savings*0.0285;break;
                        case "Ambank": predictedDeposit=savings*0.0255;break;
                        default: predictedDeposit=savings*0.0265;break;
                    
                    }
       return predictedDeposit;
}
     
// pop up message
    public static void popupMessage(Label label) {
     label.setStyle("-fx-text-fill:black;");
     label.setFont(Font.font("Anton", 15));
     label.setLayoutX(110);
     label.setLayoutY(50);
    Stage popupStage = new Stage();
    StackPane root = new StackPane(label);

    Scene scene = new Scene(root,300,100);
    popupStage.setScene(scene);
    popupStage.show();

    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    delay.setOnFinished(event -> popupStage.close());
    delay.play();
}
   
 // main method
    public static void main (String[] args){
        launch(args);
    }
    
}