package MediatorElements;

public class Buyer extends User {

	private String nickName;
	private String password;
	private Mediator mediatore;

	public Buyer(Mediator mediatore, String nickName, String password) {
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

	public void acquista(String prodotto, Seller venditore) {
		mediatore.transazione(venditore, prodotto, this);

	}

	@Override
	public String getNickName() {
		return this.nickName;
	}

}
