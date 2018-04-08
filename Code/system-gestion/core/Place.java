package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import misc.Visitable;
import misc.Visitor;

public abstract class Place {

	protected Etat etat;
	protected Section section;
	protected Itineraire itineraire;

	
	protected Place(Section section) {
		this.section = section;
		etat = new EtatDisponible();
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
	
	public Etat getetat(){return this.etat;}
	

	/**
	 * 
	 * @param section
	 */
	public void setSection(Section section) {
		this.section = section;
	}
	
	public Section getSection() {
		return this.section;
	}
	
	
	public double getPrix() {
		return itineraire.getPrix() * (section.getPourcentageTarif() /100);
	}
	
	
//	public abstract void accept(Visitor visitor);
	

}