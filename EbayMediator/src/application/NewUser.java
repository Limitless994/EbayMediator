package application;

import java.net.URL;
import java.util.ResourceBundle;

import MediatorElements.Buyer;
import MediatorElements.EbayMediator;
import MediatorElements.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;	
import javafx.stage.Stage;



public class NewUser implements Initializable {
	@FXML
	private Label status;
	@FXML
	private TextField username;
	@FXML
	private TextField password;


	public void addUser(ActionEvent event) throws Exception {	
		Buyer b = new Buyer(EbayMediator.getInstance(),username.getText(),password.getText());
		status.setText("Thanks for your credit card");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}


}
