package MediatorElemnts;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
 
    private String nickName;
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
	
	public Seller(Mediator mediatore, String nickName) {
        this.mediatore = mediatore;
        this.nickName = nickName;
         
        this.mediatore.aggiungi(this);
    }
     
    public void vendi(String prodotto, Buyer acquirente) {
        mediatore.transazione(this, prodotto, acquirente);
        System.out.println("Venduto " + prodotto + " A "+acquirente.getNickName());
    }
 
    @Override
    public String getNickName() {
        return this.nickName;
    }


}