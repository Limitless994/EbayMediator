package application;

import java.net.URL;
import java.util.ResourceBundle;

import MediatorElements.User;
import javafx.event.ActionEvent;

public interface EbayMediatorProxy {
	public void Login(ActionEvent event) throws Exception;
    public void initialize(URL arg0, ResourceBundle arg1);

}
