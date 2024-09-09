package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ClientController {
	
	
	private Client model =new Client();
	private ClientView view = new ClientView();
	public ClientController() {

		
	}
	
	
	@FXML
	private Button submit;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TextField pid;
	
	
	public void OnSubmit() throws Exception {
		System.out.println("add client executed");
		Main mm=new Main();
		boolean x=true;
		int id = Integer.parseInt(pid.getText());
    	for(int j = 0;j < Main.model.getAllPartment().size() ; j++)            	
    		if(id == Main.model.getAllPartment().get(j).Id) {
    			Main.instance.addClient(Main.model.getAllPartment().get(j),name.getText().toString(),phone.getText().toString());
    			System.out.println("add client call main");
    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    			alert.setTitle("Add client Success");
    			alert.setHeaderText("Client Added");
    			alert.showAndWait();
    			x=false;
    			mm.ChangeScene("Main.fxml");
    			break;
    		}
    	if(!x) {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Add client failed");
			alert.setHeaderText("No Apertment id found");
			alert.showAndWait();
    		
    	}

		//mm.ChangeScene("Main.fxml");

		

	}
}
	
