package application;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SalePartmentController {
	
    //declaring the variables model and view  
	Partment model=new SalePartment();
	//RentRegularView View=new RentRegularView();
	
	private Office ofc=new Office();


    
    
	public SalePartmentController() 
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

	
	
	public void OnSubmitInformation() throws Exception {
		Main mm=new Main();
		int ID = Integer.parseInt(id.getText());
		int NOR = Integer.parseInt(nor.getText());
		int RAT = Integer.parseInt(rat.getText());
		int PRI = Integer.parseInt(price.getText());
		double ARE= Double.parseDouble(area.getText());
		String add=address.getText().toString();
		model = new SalePartment(ID,add,ARE,NOR,RAT,PRI);  // add new sale apartment
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
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Add Sale Partment Success");
		alert.setHeaderText("Sale Partment Added");
		alert.showAndWait();
		mm.ChangeScene("Main.fxml");
		}
		if(num) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Add Sale Partment Fail");
			alert.setHeaderText("Sale Partment not Added");
			alert.showAndWait();
		}


		

	}

}
