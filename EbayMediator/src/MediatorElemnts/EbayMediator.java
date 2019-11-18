package MediatorElemnts;

import java.util.ArrayList;
import java.util.List;

public class EbayMediator extends Mediator {

	private List<Seller> sellers = new ArrayList<Seller>();
	private List<Buyer> buyers = new ArrayList<Buyer>();

	@Override
	public void aggiungi(User s) {
		if(s instanceof Seller)
			sellers.add((Seller) s);
		else
			buyers.add((Buyer)s);
	}

	@Override
	public void transazione(Seller venditore, String prodotto, Buyer acquirente) {
		for(Seller u: sellers){
			if( u.getNickName().equals(venditore) ){
				u.vendi(prodotto, acquirente);
			}
		}
	}
}
