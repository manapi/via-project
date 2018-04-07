package interfaceVol;

public class AirP extends SectionAvion {
	
	public AirP(int nbRangees, DispoSiegeAvion disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 60;
	}
	@Override
	public String getType() {
		return "P";
	}
}