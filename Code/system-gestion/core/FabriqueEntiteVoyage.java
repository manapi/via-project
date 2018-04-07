package core;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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

	public abstract Itineraire creerItineraire(String id, Date dateDepart, Date dateArrivee, 
			Compagnie compagnie, List<Station> arrets);
}