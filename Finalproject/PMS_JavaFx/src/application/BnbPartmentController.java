package application;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class BnbPartmentController {
	
    //declaring the variables model and view  
	Partment model=new RentBnb();
	RentRegularView View=new RentRegularView();
	
	private Office ofc=new Office();


    
    
	public BnbPartmentController() 
	{
		
	}
	
	@FXML
	private Button submit;
	@FXML
	private TextField id;
	@FXML
	private TextField address;
	@FXML
	private TextField area;
	@FXML
	private TextField nor;
	@FXML
	private TextField rat;
	@FXML
	private TextField price;
	@FXML
	private TextField time;
	@FXML
	private TextField day;
	
	
	public void OnSubmitInformation() throws Exception {
		Main mm=new Main();
		int ID = Integer.parseInt(id.getText());
		int NOR = Integer.parseInt(nor.getText());
		int RAT = Integer.parseInt(rat.getText());
		int PRI = Integer.parseInt(price.getText());
		double ARE= Double.parseDouble(area.getText());
		String add=address.getText().toString();
		int tim = Integer.parseInt(time.getText());
		int dy = Integer.parseInt(day.getText());
		model = new RentBnb(ID,add,ARE,NOR,RAT,PRI,tim,dy);       				
		boolean num = true;
		for(int i =0; i < Main.model.getAllPartment().size();i++) {
			if(Main.model.getAllPartment().get(i).equals(model) == true) {
				num = true; 
				break;
			}
			else { 
				 num = false;
			}
		}	        				
		if(!num) {
			Main.model.addPartment(model);
			Main.model.addRent(model);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Add Bnb Partment Success");
			alert.setHeaderText("BnbPartment Added");
			alert.showAndWait();
			mm.ChangeScene("Main.fxml");
		}
		if(num) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Add Bnb Partment Fail");
			alert.setHeaderText("Bnb Partment not Added");
			alert.showAndWait();
		}
		


	}

}