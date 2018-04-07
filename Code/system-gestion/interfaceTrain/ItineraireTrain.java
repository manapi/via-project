package interfaceTrain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Place;
import core.Section;
import core.Station;
import interfaceVol.SectionAvion;
import interfaceVol.SiegeAvion;
import misc.Visitor;

public class ItineraireTrain extends Itineraire {
	private Train train;

	public ItineraireTrain(String id, Date dateDepart, Date dateArrivee,
			Compagnie compagnie, List<Station> arrets) {
			
			super(id, dateDepart, dateArrivee, compagnie, arrets);
			train = new Train();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerSection(Section section) {
		if(section instanceof SectionTrain) {
			SectionTrain secTrain = (SectionTrain) section;
			train.addSection(secTrain);
			placesDisponibles += secTrain.getNombrePlaces();
			
			//Creer places
			List<Place> sieges = new ArrayList<Place>();
			for(int i=0; i < secTrain.getNombreRangees(); i++) {
				for(int j=0; j< secTrain.getNombreColonnes(); j++) {
					sieges.add(new SiegeTrain(i, j, secTrain));
				}
			}
			places.put(section.getType(), sieges);
		}
	}

	@Override
	public void supprimerSection(Section section) {
		if(section instanceof SectionTrain) {
			SectionTrain secTrain = (SectionTrain) section;
			train.removeSection(secTrain);
			placesDisponibles -= secTrain.getNombrePlaces();
			places.remove(section.getType());
		}
	}

	@Override
	public int getNombrePlaces(String section) {
		return train.getNombrePlaces(section);
	}

}