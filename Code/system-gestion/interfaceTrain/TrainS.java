package interfaceTrain;

public class TrainS extends DispoSiegeTrain {
	
	public TrainS() {
		this.nombreColonnes = 3;
		this.positionAllee = "entre 1 et 2";
	}

	@Override
	public String getType() {
		return "S";
	}
}