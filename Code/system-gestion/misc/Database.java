package misc;
import java.util.HashMap;

import core.Compagnie;
import core.Itineraire;
import core.Station;
import reservation.Reservation;

public class Database implements Subject {

	private HashMap<Integer, Reservation> reservations;
	private HashMap<String, Compagnie> compagnies;
	private HashMap<String, Station> stations;
	private HashMap<String, Itineraire> itineraires;

	/**
	 * 
	 * @param observer
	 */
	public void registerObserver(Observer observer) {
		// TODO - implement Database.registerObserver
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param observer
	 */
	public void unregisterObserver(Observer observer) {
		// TODO - implement Database.unregisterObserver
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param observer
	 */
	public void notifyObserver(Observer observer) {
		// TODO - implement Database.notifyObserver
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		// TODO - implement Database.notifyObservers
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numero
	 */
	public Reservation getReservations(int numero) {
		// TODO - implement Database.getReservations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numero
	 * @param reservation
	 */
	public void setReservations(int numero, Reservation reservation) {
		// TODO - implement Database.setReservations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Compagnie getCompagnies(String id) {
		// TODO - implement Database.getCompagnies
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void setCompagnies(String id) {
		// TODO - implement Database.setCompagnies
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Station getStations(String id) {
		// TODO - implement Database.getStations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param station
	 */
	public void setStations(String id, Station station) {
		// TODO - implement Database.setStations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ide
	 */
	public HashMap<String, Itineraire> Itineraire(String ide) {
		// TODO - implement Database.Itineraire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param itineraire
	 */
	public void setItineraires(String id, Itineraire itineraire) {
		// TODO - implement Database.setItineraires
		throw new UnsupportedOperationException();
	}

}