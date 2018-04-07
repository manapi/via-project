package interfaceCroisiere;

public class BoatD extends SectionPaquebot {
	
	public BoatD(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 100;
		this.maxPersonnes = 6;
	}
	
	public BoatD() {
		this(0);
	}

	@Override
	public String getType() {
		return "D";
	}
}