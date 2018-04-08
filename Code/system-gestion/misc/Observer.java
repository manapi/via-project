package misc;

import core.Compagnie;
import core.Itineraire;
import core.Station;
import reservation.Reservation;

public interface Observer {

	/**
	 * 
	 * @param arg
	 */
	public void update(Reservation reservation);
	public void update(Compagnie compagnie);
	public void update(Station station);
	public void update(Itineraire itineraire);

}