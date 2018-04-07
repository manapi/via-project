package interfaceCroisiere;

public class BoatS extends SectionPaquebot {
	
	public BoatS(int nbCabines) {
		super(nbCabines);
		this.pourcentageTarif = 90;
		this.maxPersonnes = 5;
	}
	
	public BoatS() {
		this(0);
	}
	
	@Override
	public String getType() {
		return "S";
	}
}