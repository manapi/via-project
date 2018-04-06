package core;
import misc.Visitable;
import misc.Visitor;

public abstract class Section implements Visitable {

	protected double pourcentageTaric;

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor) {
		// TODO - implement Section.accept
		throw new UnsupportedOperationException();
	}

}