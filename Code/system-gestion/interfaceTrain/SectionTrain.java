package interfaceTrain;
import core.Section;
import interfaceVol.DispoSiegeAvion;
import misc.Visitor;

public abstract class SectionTrain extends Section {

	protected int nombreRangees;
	protected DispoSiegeTrain disposition;
	
	protected SectionTrain(int nombreRangees, DispoSiegeTrain disposition) {
		this.nombreRangees = nombreRangees;
		this.disposition = disposition;
	}
	
	public int getNombreRangees() {
		return nombreRangees;
	}
	
	public void setNombreRangees(int nombreRangees) {
		this.nombreRangees = nombreRangees;
	}
	
	public void setDisposition(String type) {
		if(type.toUpperCase() == "S") {
			this.disposition = new TrainS();
		}
	}
	
	public DispoSiegeTrain getDisposition(){
		return this.disposition;
	}
	
	public int getNombreColonnes() {
		return disposition.getNombreColonne();
	}
	
	public int getNombrePlaces() {
		return disposition.getNombreColonne() * nombreRangees;
	}
	
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	
	public String getTypeDispo() {
		return this.getType() + disposition.getType();
	}

}