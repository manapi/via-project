package interfaceCroisiere;
import core.Etat;
import core.Itineraire;
import core.Place;
import misc.Visitor;

public class Cabine extends Place {
	private int numero;
	
	public Cabine(int numero, SectionPaquebot section, Itineraire itin) {
		super(section, itin);
		this.numero = numero;
		this.section=section;

		
	}

//	@Override
//	public void accept(Visitor visitor) {
//		visitor.visit(this);
//		
//	}
	
}