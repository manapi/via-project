package interfaceVol;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Station;

public class FabriqueEntiteVoyageAvion extends FabriqueEntiteVoyage {

	private static FabriqueEntiteVoyageAvion instance; 
	
	private FabriqueEntiteVoyageAvion(){};
	
	public static FabriqueEntiteVoyageAvion getInstance() {
        if (instance == null) {
        	instance = new FabriqueEntiteVoyageAvion();
        }
        return instance;
    }
	
	/**
	 * 
	 * @param id
	 */
	public Compagnie creerCompagnie(String id) {
		return new CompagnieAerienne(id);
	}

	/**
	 * 
	 * @param id
	 * @param ville
	 */
	public Station creerStation(String id, String ville) {
		return new Aeroport(id, ville);
	}

	@Override
	public Itineraire creerItineraire(String id, Date dateDepart, Date dateArrivee,
			Compagnie compagnie, List<Station> arrets) {
		return new Vol(id, dateDepart, dateArrivee, compagnie, arrets);
	}

}