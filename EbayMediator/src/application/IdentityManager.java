package application;

import MediatorElements.Buyer;
import MediatorElements.EbayMediator;
import MediatorElements.Seller;
import MediatorElements.User;

public class IdentityManager {

	public static User checkIdentity(String username, String password) {
		User loggedUser=null;
		for(Seller b : EbayMediator.getInstance().sellers) {
			if(username.equals(b.getNickName()) && password.equals(b.getPassword())) {
				loggedUser=b;
			}	
		}
		for(Buyer b : EbayMediator.getInstance().buyers) {
			if(username.equals(b.getNickName()) && password.equals(b.getPassword())) {
				loggedUser=b;
			}	
		}
		return loggedUser;
	}
}
