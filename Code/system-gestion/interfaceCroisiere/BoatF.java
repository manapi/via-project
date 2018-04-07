package interfaceCroisiere;

public class BoatF extends SectionPaquebot {
	
	public BoatF(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 90;
		this.maxPersonnes = 6;
	}
	
	public BoatF() {
		this(0);
	}
	
	@Override
	public String getType() {
		return "F";
	}
}