package commande;
import core.EntiteVoyage;
import misc.Database;

public abstract class SupprimerEntiteVoyage implements Commande {

	protected EntiteVoyage entiteVoyage;
	protected Database db;
	
	public SupprimerEntiteVoyage(Database db, EntiteVoyage entite) {
		this.db = db;
		this.entiteVoyage = entite;
	}
	
	@Override
	public abstract void execute();
	
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}