package interfaceCroisiere;
import core.Etat;
import core.Place;
import misc.Visitor;

public class Cabine extends Place {
	private int numero;
	
	public Cabine(int numero, SectionPaquebot section) {
		super(section);
		this.numero = numero;
		this.section=section;

		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
	
}