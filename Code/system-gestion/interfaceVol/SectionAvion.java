package interfaceVol;
import core.Section;

public abstract class SectionAvion extends Section {

	protected int nombreRangees;
	protected DispoSiegeAvion disposition;
	
	protected SectionAvion(int nombreRangees, DispoSiegeAvion disposition) {
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