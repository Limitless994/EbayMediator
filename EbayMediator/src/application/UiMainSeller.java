package application;
import java.net.URL;
import java.util.ResourceBundle;
import MediatorElements.EbayMediator;
import MediatorElements.Mediator;
import MediatorElements.Seller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class UiMainSeller implements Initializable {
	@FXML
	private ImageView preview;
	@FXML
	private ListView<String> listview = new ListView<String>();
	@FXML
	private Label userLogged;
	@FXML
	private TextField newProduct;


	ObservableList<String> sellerList = FXCollections.observableArrayList();
	ObservableList<String> products = FXCollections.observableArrayList();
	Mediator mediator = EbayMediator.getInstance();
	Seller s = (Seller)EbayMediatorProtectionProxy.getUserLogged();
	boolean alreadyLoaded=false;

	public void loadList(ActionEvent event) throws Exception {
		if(!alreadyLoaded) {
			products.removeAll(products);
			products.addAll(s.getProducts());
			listview.getSelectionModel().clearAndSelect(0);
			preview.setImage(new Image(listview.getSelectionModel().getSelectedItem()+".png"));
			alreadyLoaded=true;
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
			}		}

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
	public void addProduct(ActionEvent event) throws Exception {
		if(alreadyLoaded) {
			for(Seller seller : EbayMediator.getInstance().sellers) {
				if(seller.equals(s)) {
					seller.addProduct(newProduct.getText());
					products.add(newProduct.getText());
				}
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listview.setItems(products);
		userLogged.setText(EbayMediatorProtectionProxy.getUserLogged().getNickName());
	}

}