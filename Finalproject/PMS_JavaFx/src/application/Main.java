package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
	public static Office model = new Office();
	public static OfficeView view = new OfficeView();
	public static Scanner scan = new Scanner(System.in);
	private static Stage stg;
	public static List<String> strr = new ArrayList<>();
	public static String[] sortedsrr;
	
	public static Main instance;
	
	@FXML
	private Button addR;
	@FXML
	private Button addbb;
	@FXML
	private Button addsa;
	@FXML
	private Button showPartment;
	@FXML
	private Button priceRP;
	@FXML
	private Button expensiveRA;
	@FXML
	private Button expensiveBB;
	@FXML
	private Button addClient;
	@FXML
	private Button CPartClint;
	@FXML
	private Button AF;
	@FXML
	private Button DisCosAprt;
	@FXML
	private Button CosCerAprt;
	@FXML
	private Button exit;
	@FXML
	private TextArea TA;
	@FXML
	private Button showSA;
	@FXML
	private Button showRA;
	@FXML
	private Button showBB;
	@FXML
	private TextField id;
	@FXML
	private TextField id1;
	@FXML
	private TextField DM;
	@FXML
	private TextField id2;
	@FXML
	private TextField id3;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		if(instance==null) {
			instance=this;
		}
		try {
			stg=primaryStage;
			primaryStage.setResizable(false);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,1280,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addClient(Partment partment,String n,String p) {
		Client client = new Client(n, p);
		boolean num = true;
		for(int i =0; i < partment.getAllClients().size();i++) {
			if(partment.getAllClients().get(i).equals(client) == true) {
				num = true; 
				break;
			}
			else { 
				 num = false;
				 System.out.println("add client not success");
			}
		}	        				
		if(num == false)
			partment.addClient(client);
		System.out.println("add client success");
	}
	
	public static int PriceRent(Office a1, int number) {
		int cal = 0;
		for(int i = 0;i < a1.getAllRents().size() ; i++)
			if(number == a1.getAllRents().get(i).Id) {
				cal=a1.getAllRents().get(i).price * a1.getAllRents().get(i).time;				
			}
		return cal;
	}
	
	public void ChangeScene(String fxml) throws IOException {
		
		Parent Pan=FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(Pan);
	}
	
	
	public void sortStrings(String[] arr, int n)
    {
		
        String temp;
 
        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++)
            {
                if (arr[j].compareTo(arr[i]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            TA.appendText(arr[i].toString()+"\n");
        	}
        
    }

	
	public void AddPartmentR() throws IOException{

		ChangeScene("RegularPartment.fxml");
		
	} 
	public void AddPartmentBB() throws IOException{

		ChangeScene("BnbPartment.fxml");
		
	}
	public void AddPartmentS() throws IOException{
		ChangeScene("SalePartment.fxml");
		
	}
	public void showPartment() throws IOException{
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Apartments***\n");
        TA.appendText(view.toString(model.getAllPartment())); //office view class to display all apartment
		
	} 
	
	
	public void PriceRPartment() throws IOException{
		
		int cal = 0;
		boolean x=true;
		int ID = Integer.parseInt(id.getText());
		for(int i = 0;i < model.getAllRents().size() ; i++) {
			if(ID== model.getAllRents().get(i).Id) {
				cal=model.getAllRents().get(i).price * model.getAllRents().get(i).time;
				x=false;
				TA.setEditable(false);
				TA.setText(String.valueOf(cal));
			}
		}
		if(x) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("No data found");
			alert.setHeaderText("No data !");
			alert.showAndWait();
		}


	}
	public void MostExpensiveRAApartment() throws IOException{
		int big = 0;
		int m = Integer.parseInt(DM.getText());
		 for(int i = 0;i < model.getAllRents().size() ; i++) {
			 if(model.getAllRents().get(i) instanceof RentRegular) {
				 if(m == model.getAllRents().get(i).time) {
					 big = Math.max(big, PriceRent(model, model.getAllRents().get(i).Id));
			 }
		}
	}
		 if(big !=0) {
		 	TA.setEditable(false);
			TA.setText(String.valueOf(big));}
		 else {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("No data found");
			alert.setHeaderText("There is no patrment with this rental period !");
			alert.showAndWait();}
	 }
		
	public void MostExpensiveBBApartment() throws IOException{
		
		int big = 0;
		int m = Integer.parseInt(DM.getText());
 		for(int i = 0;i < model.getAllRents().size() ; i++) {
 			if(model.getAllRents().get(i) instanceof RentBnb) {
 				if(m == model.getAllRents().get(i).time) {
 					 big = Math.max(big, PriceRent(model, model.getAllRents().get(i).Id));
		 }
	 }
 }
 		if(big !=0) {

		 	TA.setEditable(false);
			TA.setText(String.valueOf(big));}
		 else {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("No data found");
			alert.setHeaderText("There is no patrment with this rental period !");
			alert.showAndWait();}		
}
	public void showSAPartment() throws IOException{
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Sale Apartments***\n");
		int size1 = model.getAllPartment().size();
		for(int i = 0;i < size1 ; i++) { 
			if(model.getAllPartment().get(i) instanceof SalePartment) 
				TA.appendText(model.getAllPartment().get(i).toString());
		}
	
		
	}
	public void showRAPartment() throws IOException{
		
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Regular Rent Apartments***\n");
		int size1 = model.getAllPartment().size();
		for(int i = 0;i < size1 ; i++) { 
			if(model.getAllPartment().get(i) instanceof RentRegular) 
				TA.appendText(model.getAllPartment().get(i).toString());
		}
	}
	public void showBBPartment() throws IOException{
		
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Rent B&B Apartments***\n");
		int size1 = model.getAllPartment().size();
		for(int i = 0;i < size1 ; i++) { 
			if(model.getAllPartment().get(i) instanceof RentBnb) 
				TA.appendText(model.getAllPartment().get(i).toString());
		}
	}
	public void AddClient() throws IOException{
		ChangeScene("Client.fxml");
	}
	public void CopyPartmentClient() throws IOException{
		
		try {
    		ArrayList<Client> list190 = new ArrayList<Client>();
    		Partment c190 = null;
    		for(int j = 0;j < model.getAllPartment().size() ; j++) {
    		System.out.println(model.getAllPartment().get(j));
    		}
    		int id190 = Integer.parseInt(id2.getText());
    		System.out.println("");
    		for(int j = 0;j < model.getAllPartment().size() ; j++) {
    			if(id190 == model.getAllPartment().get(j).Id) {
    			c190  = model.getAllPartment().get(j).clone();
    			list190 = (ArrayList<Client>)model.getAllPartment().get(j).getAllClients().clone();
    			}
		}
    		TA.setText(c190.toString());
    		TA.appendText(c190.getAllClients().toString());
    		System.out.println();
    	}catch (CloneNotSupportedException c) {
			
		}
		
	}
	public void AgencyFee() throws IOException{
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Agents Fees***\n");
		
		for(int j = 0;j < model.getAllPartment().size() ; j++) {

    		TA.appendText(model.getAllPartment().get(j).Agentfees(model.getAllPartment().get(j)).toString());
	
    	}
		
	}
	public void DisplayCostumerApartSN() throws IOException{
		
		TA.setEditable(false);
        TA.setWrapText(true);     // New line of the text exceeds the text area
        TA.setPrefRowCount(10);
        TA.setText("***Sorted Result***\n");
    	int num=0;
    	int choose = Integer.parseInt(id3.getText());
    	for(int j = 0;j < model.getAllPartment().size() ; j++)            	
    		if(choose == model.getAllPartment().get(j).Id) {
    			for(int l = 0; l < model.getAllPartment().get(j).getAllClients().size(); l++) {	            				
    				num++;
    			}
    		}
    	String [] str = new String [num];
    	for(int j = 0;j < model.getAllPartment().size() ; j++)            	
    		if(choose == model.getAllPartment().get(j).Id) {
    			for(int l = 0; l < model.getAllPartment().get(j).getAllClients().size(); l++) {	            				
    				str [l] = model.getAllPartment().get(j).getAllClients().get(l).getName();
    			}
    		}
    	sortStrings(str, num);
	
	}
	public void CostumerCA() throws IOException{
		
		
		for(int i = 0;i < model.getAllPartment().size() ; i++) {
			
    		//System.out.println(a1.getAllPartment().get(i));
		}


		int ID = Integer.parseInt(id1.getText());
		boolean x=false;
		for(int j = 0;j < model.getAllPartment().size() ; j++) {           	
    		if(ID == model.getAllPartment().get(j).Id) {
    			TA.setEditable(false);
                TA.setWrapText(true);     // New line of the text exceeds the text area
                TA.setPrefRowCount(10);
    			TA.setText(model.getAllPartment().get(j).getAllClients().toString());
    			x=true;
    		}
		}
		if(!x)
		{
			TA.setText("No Data found");
		}		
		
	}
	public void OnExit() throws IOException{
		 Platform.exit();
	}
	
	
	public static void main(String[] args) throws IOException,FileNotFoundException {
		try {
		if(Files.exists(Paths.get("apartment.dat")) && Files.exists(Paths.get("apartmentrent.dat")) ) {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("apartment.dat"));
		ArrayList<Partment> a11 = (ArrayList<Partment>) in.readObject();
    	 in.close();
    	 for(int i = 0; i<a11.size();i++ ) {
    		 model.addPartment(a11.get(i));
    	 }
    	 ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("apartmentrent.dat"));
			ArrayList<Partment> a10 = (ArrayList<Partment>) in1.readObject();
     	 in1.close();
     	 for(int i = 0; i<a10.size();i++ ) {
     		 model.addRent(a10.get(i));
     	 }
     	 
		}else {	 
        
		
        Partment c21 = new SalePartment(2,"ziona",167,10,9,450);
		Partment c15 = new SalePartment(3,"avivim",99.4,6,5,300);
		Client d31 = new Client("0546011778", "yossi");
		Client d33 = new Client("0546010779", "hossef");
		Client d3 = new Client("0546011378", "yossiel");
		Client d30 = new Client("0546015779", "hossefel");
		
		model.addPartment(c15);
		model.addPartment(c21);
		c15.addClient(d30);
		c15.addClient(d3);
		c21.addClient(d33);
		c21.addClient(d31);
		
		Partment c56 = new RentBnb(5, "tel", 144, 7,8,100, 3200, 0);
		Partment c31 = new RentBnb(6, "tal", 125, 9,7, 80, 3200, 0);
		Client d1 = new Client("0546111778", "dvir");
		Client d56 = new Client("0546010779", "inbal");
		Client d19 = new Client("0543011378", "limor");
		Client d9 = new Client("0547015779", "israel");
		
		model.addPartment(c56);
		model.addPartment(c31);
		model.addRent(c56);
		model.addRent(c31);
		c56.addClient(d1);
		c56.addClient(d56);
		c31.addClient(d19);
		c31.addClient(d9);
		
		Partment c123 = new RentRegular(167896, "yago", 100, 8,5,30, 12, 0);			
		Partment c4 = new RentRegular(167898, "gogo", 154, 8,6,20, 12, 0);
		Client d11 = new Client("0546009778", "yossi");
		Client d12 = new Client("0545010779", "yossef");
		Client d13 = new Client("0540012378", "nati");
		Client d14 = new Client("0523515779", "liran");
		
		model.addPartment(c4);
		model.addPartment(c123);
		model.addRent(c123);
		model.addRent(c4);
		c4.addClient(d11);
    	 c4.addClient(d12);
		c123.addClient(d13);
		c123.addClient(d14);
		
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		launch(args);
	}
	
}