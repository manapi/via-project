package interfaceCroisiere;

public class BoatO extends SectionPaquebot {
	
	public BoatO(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 75;
		this.maxPersonnes = 2;
	}
	@Override
	public String getType() {
		return "O";
	}
}