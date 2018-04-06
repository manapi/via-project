package commande;

import core.EntiteVoyage;
import core.Itineraire;
import core.Station;
import misc.Database;

public class SupprimerItineraire extends SupprimerEntiteVoyage {

	/**
	 * 
	 * @param id
	 */
	public SupprimerItineraire(Database db, EntiteVoyage entite) {
		super(db, entite);
	}

	public void execute() {
		db.removeItineraire(entiteVoyage.getId());
	}

	public void cancel() {
		if(entiteVoyage instanceof Itineraire) {
			db.setItineraire((Itineraire)entiteVoyage);
		}
	}

}