package core;
import misc.Visitable;
import misc.Visitor;

public abstract class Section implements Visitable {

	protected int pourcentageTarif;

	/**
	 * 
	 * @param visitor
	 */
	public abstract void accept(Visitor visitor);


	
	
	public int getPourcentageTarif() {
		return pourcentageTarif;
	}
	
	public abstract int getNombrePlaces();
	
	public abstract String getType();

}