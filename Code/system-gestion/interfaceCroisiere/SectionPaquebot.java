package interfaceCroisiere;
import core.Section;

public abstract class SectionPaquebot extends Section {
	protected int maxPersonnes;
	protected int nbCabines;
	
	protected SectionPaquebot(int nbCabines) {
		this.nbCabines = nbCabines;
	}
	
	public int getMaxPersonnes(){
		return maxPersonnes;
	}
	
	public int getNombrePlaces() {
		return nbCabines;
	}
}