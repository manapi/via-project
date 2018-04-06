package commande;
import core.Itineraire;
import core.Section;

public class CreerSection implements Commande {

	private Itineraire itineraire;
	private String idItineraire;
	private Section section;

	/**
	 * 
	 * @param fabrique
	 * @param idItineraire
	 */
	public CreerSection(Itineraire itineraire, String type) {
		this.itineraire = itineraire;
		// TODO - implement CreerSection.CreerSection
		throw new UnsupportedOperationException();
	}

	public void execute() {
		// TODO - implement CreerSection.execute
		throw new UnsupportedOperationException();
	}

	public void cancel() {
		// TODO - implement CreerSection.cancel
		throw new UnsupportedOperationException();
	}

}