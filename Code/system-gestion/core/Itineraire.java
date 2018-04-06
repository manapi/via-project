package core;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import misc.Visitable;

public abstract class Itineraire extends EntiteVoyage implements Visitable {

	protected Date dateDepart;
	protected Time heureDepart;
	protected Time heureArrivee;
	protected Time duree;
	protected Compagnie compagnie;
	//protected int numero;
	protected double prix;
	protected int placesDisponibles;
	protected List<Place> places;
	protected List<Station> arrets;
	
	public Itineraire(String id, Date dateDepart, Time heureDepart, Time heureArrivee,
		Time duree, Compagnie compagnie, List<Station> arrets) {
		super(id);
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.duree = duree;
		this.compagnie = compagnie;
		this.arrets = new ArrayList<Station>(arrets);
		
		//TODO :
		this.prix = -1;
		this.placesDisponibles = 0;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}

	//public abstract void addSection(Section section);
	
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date date) {
		this.dateDepart=date;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time time) {
		this.heureDepart=time;
	}
	public Time getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Time time) {
		this.heureArrivee=time;
	}
	public Time getDuree() {
		return duree;
	}
	public void setDuree(Time time) {
		this.duree=time;
	}
	public Compagnie getCompagnie() {
		return this.compagnie;
	}
	public void setCompagnie(Compagnie compagnie) {
		this.compagnie=compagnie;
	}
	public List<Station> getArrets() {
		return arrets;
	}
	public void setArrets(List<Station> arrets) {
		this.arrets = arrets;
	}
}