package commande;

import core.EntiteVoyage;
import core.Station;
import misc.Database;

public class SupprimerStation extends SupprimerEntiteVoyage {

	/**
	 * 
	 * @param id
	 */
	public SupprimerStation(Database db, EntiteVoyage entite) {
		super(db, entite);
	}

	public void execute() {
		db.removeStation(entiteVoyage.getId());
	}

	public void cancel() {
		if(entiteVoyage instanceof Station) {
			db.setStation((Station)entiteVoyage);
		}
	}

}