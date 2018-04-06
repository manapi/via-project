package core;
public abstract class FabriqueEntiteVoyage {

	/**
	 * 
	 * @param id
	 */
	public abstract Compagnie creerCompagnie(String id);

	/**
	 * 
	 * @param id
	 * @param ville
	 */
	public abstract Station creerStation(String id, String ville);

	public abstract Itineraire creerItineraire();

}