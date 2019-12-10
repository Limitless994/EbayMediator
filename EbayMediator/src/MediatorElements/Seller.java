package MediatorElements;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

	private String nickName;
	private String password;

	private Mediator mediatore;
	private List<String> products = new ArrayList<String>();

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> prodottiInVendita) {
		this.products = prodottiInVendita;
	}
	public void addProduct(String prod) {
		this.products.add(prod);
	}

	public Seller(Mediator mediatore, String nickName,String password) {
		this.mediatore = mediatore;
		this.nickName = nickName;
		this.password = password;

		this.mediatore.aggiungi(this);
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void vendi(String prodotto, Buyer acquirente) {
		mediatore.transazione(this, prodotto, acquirente);
	}

	@Override
	public String getNickName() {
		return this.nickName;
	}


}