package interfaceCroisiere;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Place;
import core.Section;
import core.Station;
import misc.Visitor;

public class ItineraireCroisiere extends Itineraire {
	
	private Paquebot paquebot;
	
	public ItineraireCroisiere(String id, Date dateDepart, Date dateArrivee, 
			Compagnie compagnie, List<Station> arrets) {
			
			super(id, dateDepart, dateArrivee, compagnie, arrets);
			paquebot = new Paquebot();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void creerSection(Section section) {
		if(section instanceof SectionPaquebot) {
			SectionPaquebot secPaq = (SectionPaquebot) section;
			paquebot.addSection(secPaq);
			placesDisponibles += secPaq.getNombrePlaces();
			
			//Creer places
			List<Place> cabines = new ArrayList<Place>();
			for(int i=0; i < secPaq.getNombrePlaces(); i++) {
				cabines.add(new Cabine(i, secPaq));
			}
			places.put(section.getType(), cabines);
		}
	}

	@Override
	public void supprimerSection(Section section) {
		if(section instanceof SectionPaquebot) {
			SectionPaquebot secPaq = (SectionPaquebot) section;
			paquebot.removeSection((SectionPaquebot)section);
			placesDisponibles -= secPaq.getNombrePlaces();
			places.remove(section.getType());
		}
	}

	@Override
	public int getNombrePlaces(String section) {
		return paquebot.getNombrePlaces(section);
	}

	@Override
	public List<Section> getSectionList() {
		return paquebot.getSectionList();
	}

}