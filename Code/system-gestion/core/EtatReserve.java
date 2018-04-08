package core;
public class EtatReserve extends Etat {

	/**
	 * 
	 * @param place
	 */
	public void setEtat(Place place) {
		place.setEtat(this);
	}

}