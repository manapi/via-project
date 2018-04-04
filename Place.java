public abstract class Place {

	protected Etat etat;
	protected Section section;
	protected int rangee;
	protected string colonne;

	public Etat getEtat() {
		return this.etat;
	}

	/**
	 * 
	 * @param etat
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

}