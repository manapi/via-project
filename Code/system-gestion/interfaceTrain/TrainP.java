package interfaceTrain;

public class TrainP extends SectionTrain {
	
	public TrainP(int nbRangees, DispoSiegeTrain disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 60;
	}
	public TrainP() {
		this(0, null);
	}
	@Override
	public String getType() {
		return "P";
	}
}