public abstract class FabriqueEntiteVoyage {

	/**
	 * 
	 * @param id
	 */
	public abstract Compagnie creerCompagnie(string id);

	/**
	 * 
	 * @param id
	 * @param ville
	 */
	public abstract Station creerStation(string id, string ville);

	public abstract Itineraire creerItineraire();

}