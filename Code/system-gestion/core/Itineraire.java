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
	protected int numero;
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
}