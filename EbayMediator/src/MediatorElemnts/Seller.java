package MediatorElemnts;

public class Seller extends User {
 
    private String nickName;
    private Mediator mediatore;
     
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