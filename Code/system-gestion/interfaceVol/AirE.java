package interfaceVol;

public class AirE extends SectionAvion {
	
	public AirE(int nbRangees, DispoSiegeAvion disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 50;
	}
	@Override
	public String getType() {
		return "E";
	}
}