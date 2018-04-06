package commande;
import core.FabriqueEntiteVoyage;
import misc.Database;

public class CreerCompagnie extends CreerEntiteVoyage {

	/**
	 * 
	 * @param fabrique
	 * @param id
	 */
	public CreerCompagnie(Database db, FabriqueEntiteVoyage fabrique, String id) {
		super(db, fabrique, id);
	}

	public void execute() {
		db.setCompagnie(fabrique.creerCompagnie(id));
	}

	public void cancel() {
		db.removeCompagnie(id);
	}

}