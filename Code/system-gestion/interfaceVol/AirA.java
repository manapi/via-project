package interfaceVol;

public class AirA extends SectionAvion {
	
	public AirA(int nbRangees, DispoSiegeAvion disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 75;
	}
	@Override
	public String getType() {
		return "A";
	}
}