package core;
import misc.Visitable;
import misc.Visitor;

public abstract class Section implements Visitable {

	protected int pourcentageTarif;

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor) {
		// TODO - implement Section.accept
		throw new UnsupportedOperationException();
	}
	
	public int getPourcentageTarif() {
		return pourcentageTarif;
	}

}