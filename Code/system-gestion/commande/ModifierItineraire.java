package commande;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Station;
import misc.Database;

public class ModifierItineraire extends ModifierEntiteVoyage {

	private String newId;
	private Date newDateDepart;
	private Time newHeureDepart;
	private Time newHeureArrivee;
	private Time newDuree;
	private Compagnie newCompagnie;
	private List<Station> newArrets;
	
	private String oldId;
	private Date oldDateDepart;
	private Time oldHeureDepart;
	private Time oldHeureArrivee;
	private Time oldDuree;
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
	public ModifierItineraire(Database db, Itineraire itineraire, String id, Date dateDepart, Time heureDepart, Time heureArrivee, Time duree, Compagnie compagnie, List<Station> arrets) {
		super(db, itineraire);
		
		this.newId = id;
		this.newDateDepart = dateDepart;
		this.newHeureDepart = heureDepart;
		this.newHeureArrivee = heureArrivee;
		this.newDuree = duree;
		this.newCompagnie = compagnie;
		this.newArrets = arrets;
		
		this.oldId = itineraire.getId();
		this.oldDateDepart = itineraire.getDateDepart();
		this.oldHeureDepart = itineraire.getHeureDepart();
		this.oldHeureArrivee = itineraire.getHeureArrivee();
		this.oldDuree = itineraire.getDuree();
		this.oldCompagnie = itineraire.getCompagnie();
		this.oldArrets = itineraire.getArrets();
	}

	public void execute() {
		Itineraire itineraire = (Itineraire) entiteVoyage;
		itineraire.setId(newId);
		itineraire.setDateDepart(newDateDepart);
		itineraire.setHeureDepart(newHeureDepart);
		itineraire.setHeureArrivee(newHeureArrivee);
		itineraire.setDuree(newDuree);
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
		itineraire.setHeureDepart(oldHeureDepart);
		itineraire.setHeureArrivee(oldHeureArrivee);
		itineraire.setDuree(oldDuree);
		itineraire.setCompagnie(oldCompagnie);
		itineraire.setArrets(oldArrets);
		
		if(!newId.equalsIgnoreCase(oldId)) {
			db.removeItineraire(oldId);
			db.setItineraire(itineraire);
		}
	}

}