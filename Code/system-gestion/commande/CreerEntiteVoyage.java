package commande;
import core.FabriqueEntiteVoyage;
import misc.Database;

public class CreerEntiteVoyage implements Commande {

	protected FabriqueEntiteVoyage fabrique;
	protected String id;
	protected Database db;
	
	public CreerEntiteVoyage(Database db, FabriqueEntiteVoyage fabrique, String id) {
		this.fabrique = fabrique;
		this.id = id;
		this.db = db;
	}

	public void execute() {
		// TODO - implement CreerEntiteVoyage.execute
		throw new UnsupportedOperationException();
	}

	public void cancel() {
		// TODO - implement CreerEntiteVoyage.cancel
		throw new UnsupportedOperationException();
	}

}