package interfaceVol;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Section;
import core.Station;
import misc.Visitor;

public class Vol extends Itineraire {
	
	public Vol(String id, Date dateDepart, Time heureDepart, Time heureArrivee,
		Time duree, Compagnie compagnie, List<Station> arrets) {
		
		super(id, dateDepart, heureDepart, heureArrivee,duree, compagnie, arrets);
	}

	public void creerSection() {
		// TODO - implement Vol.creerSection
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}