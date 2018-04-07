package commande;
import core.FabriqueEntiteVoyage;
import misc.Database;

public abstract class CreerEntiteVoyage implements Commande {

	protected FabriqueEntiteVoyage fabrique;
	protected String id;
	protected Database db;
	
	protected CreerEntiteVoyage(Database db, FabriqueEntiteVoyage fabrique, String id) {
		this.fabrique = fabrique;
		this.id = id;
		this.db = db;
	}

	public abstract void execute();

	public abstract void cancel();

}