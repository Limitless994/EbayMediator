package application;

import MediatorElemnts.Buyer;
import MediatorElemnts.EbayMediator;
import MediatorElemnts.Mediator;
import MediatorElemnts.Seller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//launch(args);

		Mediator mediatore = new EbayMediator();

		Seller seller1 = new Seller( mediatore, "Andrea" );
		Buyer buyer = new Buyer( mediatore, "Giovanni" );

		seller1.vendi("Cicala di mare", buyer);
		buyer.acquista("DROGA", seller1);
	}

}

