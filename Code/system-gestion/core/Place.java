package core;

public abstract class Place {

	protected Etat etat;
	protected Section section;
	protected Itineraire itineraire;
	
	protected Place(Section section) {
		this.section = section;
	}

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
	
	public double getPrix() {
		return itineraire.getPrix() * (section.getPourcentageTarif() /100);
	}

}