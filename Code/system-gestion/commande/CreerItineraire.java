package commande;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Station;
import misc.Database;

public class CreerItineraire extends CreerEntiteVoyage {

	private Date dateDepart;
	private Date dateArrivee;
	private Compagnie compagnie;
	private List<Station> arrets;
	//private int numero;
	//private double prix;
	//private int placesDisponibles;

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
	public CreerItineraire(Database db, FabriqueEntiteVoyage fabrique, String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		super(db, fabrique, id);
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.compagnie = compagnie;
		this.arrets = new ArrayList<Station>(arrets);
	}

	public void execute() {
		db.setItineraire(fabrique.creerItineraire(id, dateDepart, dateArrivee, compagnie, arrets));
	}

	public void cancel() {
		db.removeItineraire(id);
	}

}