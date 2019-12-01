package application;
import java.awt.Event;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.events.KeyEvent;

import MediatorElements.Buyer;
import MediatorElements.EbayMediator;
import MediatorElements.Mediator;
import MediatorElements.Seller;
import MediatorElements.User;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		for(Buyer b : EbayMediator.getInstance().buyers) {
			if(username.getText().equals(b.getNickName()) && password.getText().equals(b.getPassword())) {
				status.setText("Login Riuscito");
				loggedUser=b;
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
				Scene scene = new Scene(root,1100,700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		}
		for(Seller b : EbayMediator.getInstance().sellers) {
			if(username.getText().equals(b.getNickName()) && password.getText().equals(b.getPassword())) {
				status.setText("Login Riuscito");
				loggedUser=b;
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
				Scene scene = new Scene(root,1100,700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		}
		status.setText("DATI NON VALIDI");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public static User getUserLogged() {

		return loggedUser;
	}

}


/*package application;
import java.awt.Event;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.events.KeyEvent;

import MediatorElemnts.EbayMediator;
import MediatorElemnts.Mediator;
import MediatorElemnts.Seller;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class LoginWindow implements Initializable {
	@FXML
	private Label status;
	@FXML
	private static TextField username;
	@FXML
	private TextField password;

	public void Login(ActionEvent event) throws Exception {
		if(username.getText().equals("user")&& password.getText().equals("pass")) {
			status.setText("Login Riuscito");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
			Scene scene = new Scene(root,1100,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}else {
			status.setText("Username o Password Errati");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public static String getUsername() {

		return username.getText();
	}

}*/