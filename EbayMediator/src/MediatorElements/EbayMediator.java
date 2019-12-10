package MediatorElements;

import java.util.ArrayList;
import java.util.List;

public class EbayMediator extends Mediator {

	private EbayMediator() {
		Seller seller1 = new Seller( this, "seller1","pass" );	
		Seller seller2 = new Seller( this, "seller2","pass" );	
		Buyer user = new Buyer(this, "user","pass");
		seller1.addProduct("Sedia");
		seller1.addProduct("Laptop");	
		seller2.addProduct("Smartphone");
	}
	private static EbayMediator m = new EbayMediator();

	public List<Seller> sellers = new ArrayList<Seller>();
	public List<Buyer> buyers = new ArrayList<Buyer>();

	@Override
	public void aggiungi(User s) {
		if(s instanceof Seller)
			sellers.add((Seller) s);
		else
			buyers.add((Buyer)s);
	}

	@Override
	public void transazione(Seller venditore, String prodotto, Buyer acquirente) {
		System.out.println("TRANSAZIONE TRA "+ venditore.getNickName() + " E "+acquirente.getNickName() +" OGGETTO: " +prodotto);
	}
	public static EbayMediator getInstance(){
		return m;
	}
}
