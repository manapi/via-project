package misc;

public interface Visitable {

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor);

}