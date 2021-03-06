package core;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import misc.Visitable;
import misc.Visitor;

public abstract class Itineraire extends EntiteVoyage implements Visitable {

	protected Date dateDepart;
	protected Date dateArrivee;
	protected Compagnie compagnie;
	//protected int numero;
	protected double prix;
	protected int placesDisponibles;
	protected Map<String, List<Place>> places;
	protected List<Station> arrets;
	
	public Itineraire(String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		super(id);
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.compagnie = compagnie;
		this.arrets = new ArrayList<Station>(arrets);
		
		//TODO :
		this.prix = -1;
		this.placesDisponibles = 0;
		this.places = new HashMap<String, List<Place>>();
	}
	

	public abstract void accept(Visitor visitor);

		
	public double getPrix() {
		return prix;
	}
	
	public double getPrixSection(String section) {
		List<Section> list = this.getSectionList();
		for(Section sec : list) {
			if(sec.getType().equalsIgnoreCase(section)) {
				double ceprix = this.prix;
				double pct = sec.getPourcentageTarif();
				double tarif = ceprix * (pct /100);
				return tarif;
			}
		}
		return -1;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public abstract List<Section> getSectionList();
	
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date date) {
		this.dateDepart=date;
	}
	
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date date) {
		this.dateArrivee=date;
	}
	
	public int getDuree() {
		// TODO - implement CreerEntiteVoyage.execute
		throw new UnsupportedOperationException();
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
	
	public abstract void creerSection(Section section);
	
	public abstract void supprimerSection(Section section);
	
	public abstract int getNombrePlaces(String section);
	
	public List<Place> getPlacesDisponibles(String section) {
		List<Place> dispos = new ArrayList<Place>();
		if(places.containsKey(section)) {
			for(Place place : places.get(section)) {
				if(place.getEtat() instanceof EtatDisponible) {
					dispos.add(place);
				}
			}
		}
		return dispos;
	}
}