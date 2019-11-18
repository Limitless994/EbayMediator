package MediatorElemnts;

public class Buyer extends User {

	  private String nickName;
	    private Mediator mediatore;
	     
	    public Buyer(Mediator mediatore, String nickName) {
	        this.mediatore = mediatore;
	        this.nickName = nickName;
	         
	        this.mediatore.aggiungi(this);
	    }
	     
	    public void acquista(String prodotto, Seller venditore) {
	        mediatore.transazione(venditore, prodotto, this);
	    }
	 
	    @Override
	    public String getNickName() {
	        return this.nickName;
	    }

}
