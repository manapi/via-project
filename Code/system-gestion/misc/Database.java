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

	public Database() {
		reservations = new HashMap<Integer, Reservation>();
		compagnies = new HashMap<String, Compagnie>();
		stations = new HashMap<String, Station>();
		itineraires = new HashMap<String, Itineraire>();
		
		//TODO : add default objects
				
	}
	
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
	public Reservation getReservation(int numero) {
		return reservations.get(numero);
	}

	/**
	 * 
	 * @param numero
	 * @param reservation
	 */
	public void setReservation(Reservation reservation) {
		reservations.put(reservation.getNumero(), reservation);
	}

	public void removeReservation(int numero) {
		reservations.remove(numero);
	}
	
	/**
	 * 
	 * @param id
	 */
	public Compagnie getCompagnie(String id) {
		return compagnies.get(id);
	}

	/**
	 * 
	 * @param id
	 */
	public void setCompagnie(Compagnie compagnie) {
		compagnies.put(compagnie.getId(), compagnie);
	}
	
	public void removeCompagnie(String id) {
		compagnies.remove(id);
	}

	/**
	 * 
	 * @param id
	 */
	public Station getStation(String id) {
		return stations.get(id);
	}

	/**
	 * 
	 * @param id
	 * @param station
	 */
	public void setStation(Station station) {
		stations.put(station.getId(), station);
	}
	
	public void removeStation(String id) {
		stations.remove(id);
	}

	/**
	 * 
	 * @param ide
	 */
	public Itineraire getItineraire(String id) {
		return itineraires.get(id);
	}

	/**
	 * 
	 * @param id
	 * @param itineraire
	 */
	public void setItineraire(Itineraire itineraire) {
		itineraires.put(itineraire.getId(), itineraire);
	}
	
	public void removeItineraire(String id) {
		itineraires.remove(id);
	}

}