package commande;
import core.EntiteVoyage;
import core.FabriqueEntiteVoyage;
import misc.Database;

public abstract class ModifierEntiteVoyage implements Commande {

	//protected FabriqueEntiteVoyage fabrique;
	protected EntiteVoyage newEntite;
	protected EntiteVoyage oldEntite;
	protected Database db;
	
	/*public ModifierEntiteVoyage(Database db, EntiteVoyage entite) {
		this.db = db;
		this.newEntite = entite;
	}*/

	public void execute() {
		// TODO - implement ModifierEntiteVoyage.execute
		throw new UnsupportedOperationException();
	}

	public void cancel() {
		// TODO - implement ModifierEntiteVoyage.cancel
		throw new UnsupportedOperationException();
	}

}