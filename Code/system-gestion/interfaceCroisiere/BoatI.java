package interfaceCroisiere;

public class BoatI extends SectionPaquebot {
	
	public BoatI(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 50;
		this.maxPersonnes = 4;
	}
	
	public BoatI() {
		this(0);
	}
	
	@Override
	public String getType() {
		return "I";
	}
}