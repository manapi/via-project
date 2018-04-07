package interfaceTrain;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Section;
import core.Station;
import interfaceVol.AirA;
import interfaceVol.AirE;
import interfaceVol.AirF;
import interfaceVol.AirP;

public class FabriqueEntiteVoyageTrain extends FabriqueEntiteVoyage {

	private static FabriqueEntiteVoyageTrain instance; 
	
	private FabriqueEntiteVoyageTrain(){};
	
	public static FabriqueEntiteVoyageTrain getInstance() {
        if (instance == null) {
        	instance = new FabriqueEntiteVoyageTrain();
        }
        return instance;
    }
	
	/**
	 * 
	 * @param id
	 */
	public Compagnie creerCompagnie(String id) {
		return new LigneTrain(id);
	}

	/**
	 * 
	 * @param id
	 * @param ville
	 */
	public Station creerStation(String id, String ville) {
		return new Gare(id, ville);
	}

	@Override
	public Itineraire creerItineraire(String id, Date dateDepart, Date dateArrivee,
			Compagnie compagnie, List<Station> arrets) {
		return new ItineraireTrain(id, dateDepart, dateArrivee, compagnie, arrets);
	}

	@Override
	public Section creerSection(String type) {
		switch(type.toUpperCase()) {
		case "E" : 
			return new TrainE();
		case "P" :
			return new TrainP();
		}
		return null;
	}

}