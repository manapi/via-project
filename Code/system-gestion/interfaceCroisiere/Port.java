package interfaceCroisiere;
import core.Station;
import misc.Visitor;

public class Port extends Station {

	public Port(String id, String ville) {
		super(id, ville);
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}