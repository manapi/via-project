package core;
public class EtatConfirme extends Etat {

	/**
	 * 
	 * @param place
	 */
	public void setEtat(Place place) {
		place.setEtat(this);
	}

}