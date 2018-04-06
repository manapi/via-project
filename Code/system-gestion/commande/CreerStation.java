package commande;
import core.FabriqueEntiteVoyage;
import misc.Database;

public class CreerStation extends CreerEntiteVoyage {

	private String ville;

	/**
	 * 
	 * @param fabrique
	 * @param id
	 * @param ville
	 */
	public CreerStation(Database db, FabriqueEntiteVoyage fabrique, String id, String ville) {
		super(db, fabrique, id);
		this.ville = ville;
		throw new UnsupportedOperationException();
	}

	public void execute() {
		db.setStation(fabrique.creerStation(id, ville));
	}

	public void cancel() {
		db.removeStation(id);
	}

}