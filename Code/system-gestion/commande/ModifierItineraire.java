package commande;

import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Station;
import misc.Database;

public class ModifierItineraire extends ModifierEntiteVoyage {

	private String newId;
	private Date newDateDepart;
	private Date newDateArrivee;
	private Compagnie newCompagnie;
	private List<Station> newArrets;
	
	private String oldId;
	private Date oldDateDepart;
	private Date oldDateArrivee;
	private Compagnie oldCompagnie;
	private List<Station> oldArrets;

	/**
	 * 
	 * @param dateDepart
	 * @param heureDepart
	 * @param heureArrivee
	 * @param duree
	 * @param numero
	 * @param prix
	 * @param placesDisponibles
	 */
	public ModifierItineraire(Database db, Itineraire itineraire, String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		super(db, itineraire);
		
		this.newId = id;
		this.newDateDepart = dateDepart;
		this.newDateArrivee = dateArrivee;
		this.newCompagnie = compagnie;
		this.newArrets = arrets;
		
		this.oldId = itineraire.getId();
		this.oldDateDepart = itineraire.getDateDepart();
		this.oldDateArrivee = itineraire.getDateArrivee();
		this.oldCompagnie = itineraire.getCompagnie();
		this.oldArrets = itineraire.getArrets();
	}

	public void execute() {
		Itineraire itineraire = (Itineraire) entiteVoyage;
		itineraire.setId(newId);
		itineraire.setDateDepart(newDateDepart);
		itineraire.setDateDepart(newDateArrivee);
		itineraire.setCompagnie(newCompagnie);
		itineraire.setArrets(newArrets);
		
		if(!newId.equalsIgnoreCase(newId)) {
			db.removeItineraire(newId);
			db.setItineraire(itineraire);
		}
	}

	public void cancel() {
		Itineraire itineraire = (Itineraire) entiteVoyage;
		itineraire.setId(oldId);
		itineraire.setDateDepart(oldDateDepart);
		itineraire.setDateDepart(oldDateArrivee);
		itineraire.setCompagnie(oldCompagnie);
		itineraire.setArrets(oldArrets);
		
		if(!newId.equalsIgnoreCase(oldId)) {
			db.removeItineraire(oldId);
			db.setItineraire(itineraire);
		}
	}

}