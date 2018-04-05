public interface Subject {

	/**
	 * 
	 * @param observer
	 */
	void registerObserver(Observer observer);

	/**
	 * 
	 * @param observer
	 */
	void unregisterObserver(Observer observer);

	/**
	 * 
	 * @param observer
	 */
	void notifyObserver(Observer observer);

	void notifyObservers();

}