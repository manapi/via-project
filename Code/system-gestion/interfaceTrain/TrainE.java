package interfaceTrain;

public class TrainE extends SectionTrain {
	
	public TrainE(int nbRangees, DispoSiegeTrain disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 50;
	}
	@Override
	public String getType() {
		return "E";
	}
}