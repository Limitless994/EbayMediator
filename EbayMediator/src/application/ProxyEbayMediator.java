package application;

import java.net.URL;
import java.util.ResourceBundle;
import MediatorElements.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;	
import javafx.stage.Stage;



public class ProxyEbayMediator implements Initializable {
	@FXML
	private Label status;
	@FXML
	private TextField username;
	@FXML
	private TextField password;

	private static User loggedUser = null ;
	
	public void Login(ActionEvent event) throws Exception {	
		loggedUser=IdentityManager.checkIdentity(username.getText(), password.getText());
		
		if(loggedUser!=null) {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/mainBuyer.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			status.setText("Login Riuscito");
		}else
			status.setText("DATI NON VALIDI");

	}
	public void openRegisterWindow(ActionEvent event) throws Exception {	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/newUserUI.fxml"));
		Scene scene = new Scene(root,300,300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public static User getUserLogged() {

		return loggedUser;
	}

}
