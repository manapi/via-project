package commande;
import core.Compagnie;
import core.EntiteVoyage;
import core.FabriqueEntiteVoyage;
import misc.Database;

public class ModifierCompagnie extends ModifierEntiteVoyage {

	private String newId;
	private String oldId;
	
	public ModifierCompagnie(Database db, Compagnie entite, String newId) {
		super(db, entite);
		this.newId = newId;
		this.oldId = entiteVoyage.getId();
	}

	public void execute() {
		entiteVoyage.setId(newId);
		
		db.removeCompagnie(oldId);
		db.setCompagnie((Compagnie)entiteVoyage);
	}

	public void cancel() {
		entiteVoyage.setId(oldId);
		
		db.removeCompagnie(newId);
		db.setCompagnie((Compagnie)entiteVoyage);
	}

}