package core;
import misc.Visitable;
import misc.Visitor;

public abstract class Section {

	protected int pourcentageTarif;



	
	
	public int getPourcentageTarif() {
		return pourcentageTarif;
	}
	
	public abstract int getNombrePlaces();
	
	public abstract String getType();
	
	public abstract String getTypeDispo();

}