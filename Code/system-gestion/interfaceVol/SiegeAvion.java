package interfaceVol;
import core.Itineraire;
import core.Place;
import misc.Visitor;

public class SiegeAvion extends Place {

	private int rangee;
	private String colonne;

	public SiegeAvion(int rangee, int colonne, SectionAvion section, Itineraire itin) {
		super(section, itin);
		
		this.rangee = rangee;
		switch(colonne) {
		case 0 : 
			this.colonne = "A";
			break;
		case 1 :
			this.colonne = "B";
			break;
		case 2 : 
			this.colonne = "C";
			break;
		case 3 :
			this.colonne = "D";
			break;
		case 4 : 
			this.colonne = "E";
			break;
		case 5 :
			this.colonne = "F";
			break;
		case 6 :
			this.colonne = "G";
			break;
		case 7 :
			this.colonne = "H";
			break;
		case 8 :
			this.colonne = "I";
			break;
		case 9 :
			this.colonne = "J";
			break;
		}
	}

//	@Override
//	public void accept(Visitor visitor) {
//		visitor.visit(this);
//		}
}