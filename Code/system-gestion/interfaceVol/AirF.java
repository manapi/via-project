package interfaceVol;

public class AirF extends SectionAvion {
	
	public AirF(int nbRangees, DispoSiegeAvion disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 100;
	}
	
	public AirF() {
		this(0, null);
	}
	
	@Override
	public String getType() {
		return "F";
	}
}