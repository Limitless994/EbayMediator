package application;

import MediatorElemnts.Buyer;
import MediatorElemnts.EbayMediator;
import MediatorElemnts.Mediator;
import MediatorElemnts.Seller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Mediator mediatore =  EbayMediator.getInstance();
		Seller seller1 = new Seller( mediatore, "Seller1" );	
		Seller seller2 = new Seller( mediatore, "Seller2" );	
		Buyer user = new Buyer(mediatore, "user","pass");
		seller1.addProduct("sedia");
		seller1.addProduct("lampada");
		seller1.addProduct("Laptop");
		mediatore.transazione(seller1, "Sedia", user);
		seller2.addProduct("smartphone");
		launch(args);

	}

}

