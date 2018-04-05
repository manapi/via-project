public abstract class Place {

	protected Etat etat;
	protected Section section;

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

	public Section getSection() {
		return this.section;
	}

	/**
	 * 
	 * @param section
	 */
	public void setSection(Section section) {
		this.section = section;
	}

}