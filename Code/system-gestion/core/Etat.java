package core;
public abstract class Etat {

	/**
	 * 
	 * @param place
	 */
	public void setEtat(Place place) {
		place.setEtat(this);
	}
}