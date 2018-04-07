package commande;
import core.Itineraire;
import core.Section;

public class CreerSection implements Commande {

	private Itineraire itineraire;
	private Section section;

	/**
	 * 
	 * @param fabrique
	 * @param idItineraire
	 */
	public CreerSection(Itineraire itineraire, Section section) {
		this.itineraire = itineraire;
		this.section = section;
	}

	public void execute() {
		this.itineraire.creerSection(section);
	}

	public void cancel() {
		this.itineraire.supprimerSection(section);
	}

}