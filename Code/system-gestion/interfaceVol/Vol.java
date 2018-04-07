package interfaceVol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Place;
import core.Section;
import core.Station;
import misc.Visitor;

public class Vol extends Itineraire {
	private Avion avion;
	
	public Vol(String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		super(id, dateDepart, dateArrivee, compagnie, arrets);
		avion = new Avion();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerSection(Section section) {
		if(section instanceof SectionAvion) {
			SectionAvion secAv = (SectionAvion) section;
			avion.addSection(secAv);
			placesDisponibles += secAv.getNombrePlaces();
			
			//Creer places
			List<Place> sieges = new ArrayList<Place>();
			for(int i=0; i < secAv.getNombreRangees(); i++) {
				for(int j=0; j< secAv.getNombreColonnes(); j++) {
					sieges.add(new SiegeAvion(i, j, secAv));
				}
			}
			places.put(section.getType(), sieges);
		}

	}

	@Override
	public void supprimerSection(Section section) {
		if(section instanceof SectionAvion) {
			SectionAvion secAv = (SectionAvion) section;
			avion.removeSection((SectionAvion)section);
			placesDisponibles -= secAv.getNombrePlaces();
			places.remove(section.getType());
		}
	}

	@Override
	public int getNombrePlaces(String section) {
		return avion.getNombrePlaces(section);
	}

}