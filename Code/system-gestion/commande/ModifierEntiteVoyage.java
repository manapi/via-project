package commande;
import core.EntiteVoyage;
import core.FabriqueEntiteVoyage;

public abstract class ModifierEntiteVoyage implements Commande {

	protected FabriqueEntiteVoyage fabrique;
	protected EntiteVoyage entiteVoyage;
	protected String id;

	public void execute() {
		// TODO - implement ModifierEntiteVoyage.execute
		throw new UnsupportedOperationException();
	}

	public void cancel() {
		// TODO - implement ModifierEntiteVoyage.cancel
		throw new UnsupportedOperationException();
	}

}