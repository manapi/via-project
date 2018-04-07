package commande;
import core.EntiteVoyage;
import core.FabriqueEntiteVoyage;
import misc.Database;

public abstract class ModifierEntiteVoyage implements Commande {

	//protected FabriqueEntiteVoyage fabrique;
	protected EntiteVoyage entiteVoyage;
	protected Database db;
	
	public ModifierEntiteVoyage(Database db, EntiteVoyage entite) {
		this.db = db;
		this.entiteVoyage = entite;
	}

	public abstract void execute();

	public abstract void cancel();

}