package application;
import java.net.URL;
import java.util.ResourceBundle;

import MediatorElements.Buyer;
import MediatorElements.EbayMediator;
import MediatorElements.Mediator;
import MediatorElements.Seller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class UiMainBuyer implements Initializable {
	@FXML
	private ImageView preview;
	@FXML
	private ListView<String> listview = new ListView<String>();
	@FXML
	private ChoiceBox<String> sellerSelector;
	@FXML
	private Label userLogged;
	@FXML
	public Button button;
	@FXML
	public Button buyButton;
	@FXML
	public Label statusVendita;

	ObservableList<String> sellerList = FXCollections.observableArrayList();
	ObservableList<String> products = FXCollections.observableArrayList();
	Mediator mediator = EbayMediator.getInstance();
	Seller currentSeller;
	private void loadData() {
		sellerList.removeAll(sellerList);
		for(Seller s:EbayMediator.getInstance().sellers) {
			sellerList.add(s.getNickName());
			if(userLogged.getText().equals(s.getNickName()))
				sellerList.remove(s.getNickName());
		}
		sellerSelector.getItems().addAll(sellerList);
	}

	public void loadList(ActionEvent event) throws Exception {
		statusVendita.setText("");
		products.removeAll(products);
		for(Seller s:EbayMediator.getInstance().sellers) {
			if(s.getNickName()==sellerSelector.getValue()) {
				currentSeller=s;
				products.addAll(s.getProducts());
				listview.getSelectionModel().clearAndSelect(0);
				System.out.println(listview.getSelectionModel().getSelectedItem());
				try{
					preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".png"));
				}catch(Exception e) {
					preview.setImage(new Image("imageNotFound.png"));
				}		
			}

		}
	}


	public void next(ActionEvent event) throws Exception {
		if(!listview.getSelectionModel().isSelected(listview.getItems().size()-1)) {
			listview.getSelectionModel().selectNext();
			System.out.println(listview.getSelectionModel().getSelectedItem());
			try{
				preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".png"));
			}catch(Exception e) {
				preview.setImage(new Image("imageNotFound.png"));
			}		
		}		
	}
	public void AddProductPopup(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/mainSeller.fxml"));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void previous(ActionEvent event) throws Exception {
		if(!listview.getSelectionModel().isSelected(0)) {
			listview.getSelectionModel().selectPrevious();
			System.out.println(listview.getSelectionModel().getSelectedItem());
			try{
				preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".png"));
			}catch(Exception e) {
				preview.setImage(new Image("imageNotFound.png"));
			}		
		}		
	}
	public void buy(ActionEvent event) throws Exception {
		Buyer tmp=(Buyer)ProxyEbayMediator.getUserLogged();
		currentSeller.vendi(listview.getSelectionModel().getSelectedItem(), (Buyer)ProxyEbayMediator.getUserLogged());
		tmp.acquista(listview.getSelectionModel().getSelectedItem(), currentSeller);
		statusVendita.setText( currentSeller.getNickName() + " ha venduto "+listview.getSelectionModel().getSelectedItem()+" a "+tmp.getNickName());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listview.setItems(products);
		userLogged.setText(ProxyEbayMediator.getUserLogged().getNickName());
		if(ProxyEbayMediator.getUserLogged() instanceof Seller) {
			button.setVisible(true);
			buyButton.setVisible(false);
		}
		else button.setVisible(false);
		loadData();
	}

}