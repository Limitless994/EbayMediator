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



public class UiMain implements Initializable {
	@FXML
	private ImageView preview;
	@FXML
	private ListView<String> listview = new ListView<String>();
	@FXML
	private ChoiceBox<String> sellerSelector;
	@FXML
	private Label userLogged;
	
	
	ObservableList<String> sellerList = FXCollections.observableArrayList();
	ObservableList<String> products = FXCollections.observableArrayList();
	Mediator mediator = EbayMediator.getInstance();
	Seller currentSeller;
	private void loadData() {
		sellerList.removeAll(sellerList);
		for(Seller s:EbayMediator.getInstance().sellers) {
			sellerList.add(s.getNickName());
		}
		sellerSelector.getItems().addAll(sellerList);
	}

	public void loadList(ActionEvent event) throws Exception {
		products.removeAll(products);
		for(Seller s:EbayMediator.getInstance().sellers) {
			if(s.getNickName()==sellerSelector.getValue()) {
				currentSeller=s;
				products.addAll(s.getProducts());
				listview.getSelectionModel().clearAndSelect(0);
				System.out.println(listview.getSelectionModel().getSelectedItem());
				preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".jpg"));


			}
		}
	}

	public void next(ActionEvent event) throws Exception {
		if(!listview.getSelectionModel().isSelected(listview.getItems().size()-1)) {
			listview.getSelectionModel().selectNext();
			System.out.println(listview.getSelectionModel().getSelectedItem());
			preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".jpg"));
		}

	}
	public void previous(ActionEvent event) throws Exception {
		if(!listview.getSelectionModel().isSelected(0)) {
			listview.getSelectionModel().selectPrevious();
			System.out.println(listview.getSelectionModel().getSelectedItem());
			preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".jpg"));
		}

	}
	public void buy(ActionEvent event) throws Exception {
	//	EbayMediator.getInstance().transazione(currentSeller, listview.getSelectionModel().getSelectedItem(),LoginWindow.getUserLogged() );
	currentSeller.vendi(listview.getSelectionModel().getSelectedItem(), (Buyer)ProxyEbayMediator.getUserLogged());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listview.setItems(products);
		userLogged.setText(ProxyEbayMediator.getUserLogged().getNickName());
		loadData();
	}

}