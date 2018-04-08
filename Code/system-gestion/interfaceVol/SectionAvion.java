package interfaceVol;
import core.Section;
import misc.Visitor;

public abstract class SectionAvion extends Section {

	protected int nombreRangees;
	protected DispoSiegeAvion disposition;
	
	protected SectionAvion(int nombreRangees, DispoSiegeAvion disposition) {
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
		switch(type.toUpperCase()) {
		case "C" :
			this.disposition = new AirC();
			break;
		case "L" :
			this.disposition = new AirL();
			break;
		case "M" :
			this.disposition = new AirM();
			break;
		case "S" :
			this.disposition = new AirS();
			break;
		}
	}
	
	public DispoSiegeAvion getDisposition(){
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