package interfaceTrain;
import core.Section;
import interfaceVol.DispoSiegeAvion;

public abstract class SectionTrain extends Section {

	protected int nombreRangees;
	protected DispoSiegeTrain disposition;
	
	protected SectionTrain(int nombreRangees, DispoSiegeTrain disposition) {
		this.nombreRangees = nombreRangees;
		this.disposition = disposition;
	}
	
	public int getNombreRangees() {
		return nombreRangees;
	}
	
	public int getNombreColonnes() {
		return disposition.getNombreColonne();
	}

}