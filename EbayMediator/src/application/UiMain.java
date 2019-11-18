package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class UiMain implements Initializable {
	@FXML
	private ImageView preview;
	@FXML
	private Label cost;
	@FXML
	private ChoiceBox<String> carSelector;
	@FXML
	private ChoiceBox<String> carSetup;
	@FXML
	private ListView<String> listview;

	ObservableList<String> carList = FXCollections.observableArrayList();
	ObservableList<String> setupList = FXCollections.observableArrayList();

	private void loadData() {
		carList.removeAll(carList);
		carList.add("Suv");
		carList.add("Hatchback");
		carList.add("Coupe");
		carList.add("Crossover");
		carSelector.getItems().addAll(carList);
		setupList.removeAll(setupList);
		setupList.add("ATTIVA");
		setupList.add("ELETTA");
		setupList.add("FUTURA");
		carSetup.getItems().addAll(setupList);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


	
}