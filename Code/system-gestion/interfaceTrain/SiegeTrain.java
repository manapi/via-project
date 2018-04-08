package interfaceTrain;
import core.Itineraire;
import core.Place;
import misc.Visitor;

public class SiegeTrain extends Place {

	private int rangee;
	private String colonne;
	
	public SiegeTrain(int rangee, int colonne, SectionTrain section, Itineraire itin) {
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
		}
	}

//	@Override
//	public void accept(Visitor visitor) {
//		visitor.visit(this);
//		
//	}

}