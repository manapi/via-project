package interfaceCroisiere;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Station;
import interfaceTrain.FabriqueEntiteVoyageTrain;

public class FabriqueEntiteVoyageBateau extends FabriqueEntiteVoyage {

	private static FabriqueEntiteVoyageBateau instance; 
	
	private FabriqueEntiteVoyageBateau(){};
	
	public static FabriqueEntiteVoyageBateau getInstance() {
        if (instance == null) {
        	instance = new FabriqueEntiteVoyageBateau();
        }
        return instance;
    }
	
	/**
	 * 
	 * @param id
	 */
	public Compagnie creerCompagnie(String id) {
		return new CompagnieCroisiere(id);
	}

	/**
	 * 
	 * @param id
	 * @param ville
	 */
	public Station creerStation(String id, String ville) {
		return new Port(id, ville);
	}

	@Override
	public Itineraire creerItineraire(String id, Date dateDepart, Date dateArrivee,
			Compagnie compagnie, List<Station> arrets) {
		return new ItineraireCroisiere(id, dateDepart, dateArrivee, compagnie, arrets);
	}

}