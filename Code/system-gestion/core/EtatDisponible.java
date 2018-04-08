package core;
public class EtatDisponible extends Etat {

	/**
	 * 
	 * @param place
	 */
	public void setEtat(Place place) {
		place.setEtat(this);
	}

}