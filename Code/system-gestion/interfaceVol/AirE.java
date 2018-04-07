package interfaceVol;

public class AirE extends SectionAvion {
	
	public AirE(int nbRangees, DispoSiegeAvion disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 50;
	}
	
	public AirE() {
		this(0, null);
	}
	
	@Override
	public String getType() {
		return "E";
	}
}