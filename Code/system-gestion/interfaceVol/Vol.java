package interfaceVol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Compagnie;
import core.Itineraire;
import core.Section;
import core.Station;
import misc.Visitor;

public class Vol extends Itineraire {
	
	public Vol(String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		
		super(id, dateDepart, dateArrivee, compagnie, arrets);
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