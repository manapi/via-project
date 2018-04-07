package interfaceTrain;

public class TrainP extends SectionTrain {
	
	public TrainP(int nbRangees, DispoSiegeTrain disposition) {
		super(nbRangees, disposition);
		this.pourcentageTarif = 60;
	}
	@Override
	public String getType() {
		return "P";
	}
}