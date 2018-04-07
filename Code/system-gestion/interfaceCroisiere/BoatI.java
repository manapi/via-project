package interfaceCroisiere;

public class BoatI extends SectionPaquebot {
	
	public BoatI(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 50;
		this.maxPersonnes = 4;
	}
	@Override
	public String getType() {
		return "I";
	}
}