package misc;

import core.Compagnie;
import core.Itineraire;
import core.Station;
import reservation.Reservation;

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
	void notifyObservers(Reservation reservation);
	void notifyObservers(Compagnie compagnie);
	void notifyObservers(Station station);
	void notifyObservers(Itineraire itineraire);


}