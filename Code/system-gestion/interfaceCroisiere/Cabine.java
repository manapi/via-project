package interfaceCroisiere;
import core.Place;

public class Cabine extends Place {
	private int numero;
	
	public Cabine(int numero, SectionPaquebot section) {
		super(section);
		this.numero = numero;
	}
	
}