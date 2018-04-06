package commande;
import core.Itineraire;

public class AssignerPrix implements Commande {

	private Itineraire itineraire;
	private double newPrix;
	private double oldPrix;

	public AssignerPrix(Itineraire itineraire, int prix) {
		this.itineraire = itineraire;
		this.newPrix = prix;
		this.oldPrix = itineraire.getPrix();
	}

	public void execute() {
		this.itineraire.setPrix(newPrix);
	}

	public void cancel() {
		this.itineraire.setPrix(oldPrix);
	}

}