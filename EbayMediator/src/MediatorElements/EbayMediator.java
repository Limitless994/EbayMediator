package MediatorElements;

import java.util.ArrayList;
import java.util.List;

public class EbayMediator extends Mediator {

	private EbayMediator() {};
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
//		venditore.vendi(prodotto, acquirente);
//		System.out.println("Venduto "+prodotto+" da " + venditore.getNickName() + " a "+acquirente.getNickName());
	}
	public static EbayMediator getInstance(){
		return m;
	}
}
