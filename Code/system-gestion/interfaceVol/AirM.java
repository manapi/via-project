package interfaceVol;

public class AirM extends DispoSiegeAvion {
	public AirM() {
		this.nombreColonnes = 6;
		this.positionAllee = "entre 3 et 4";
	}
	
	@Override
	public String getType() {
		return "M";
	}
}
