package commande;

import core.Compagnie;
import core.EntiteVoyage;
import misc.Database;

public class SupprimerCompagnie extends SupprimerEntiteVoyage {

	public SupprimerCompagnie(Database db, EntiteVoyage entite) {
		super(db, entite);
	}

	public void execute() {
		db.removeCompagnie(entiteVoyage.getId());
	}

	public void cancel() {
		if(entiteVoyage instanceof Compagnie) {
			db.setCompagnie((Compagnie)entiteVoyage);
		}
	}
}