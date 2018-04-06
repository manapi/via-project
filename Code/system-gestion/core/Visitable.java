package core;
import misc.Visitor;

public interface Visitable {

	/**
	 * 
	 * @param visitor
	 */
	void accept(Visitor visitor);

}