import java.util.*;

public class Client implements Observer, Visitor, Visitable {

	Passeport passeport;
	Collection<CarteCredit> carteCredit;
	private string nom;
	private string adresse;
	private string courriel;
	private string telephone;
	private Date dateNaissance;

	/**
	 * 
	 * @param place
	 */
	public void reserver(Place place) {
		// TODO - implement Client.reserver
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservation
	 */
	public void confirmer(Reservation reservation) {
		// TODO - implement Client.confirmer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservation
	 */
	public void modifier(Reservation reservation) {
		// TODO - implement Client.modifier
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param parameter
	 */
	public void annuler(Reservation parameter) {
		// TODO - implement Client.annuler
		throw new UnsupportedOperationException();
	}

}