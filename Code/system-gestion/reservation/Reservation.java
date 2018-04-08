package reservation;


import java.util.Date;

import core.Place;
import client.Client;

public class Reservation {

	private static int NEXT_NUMERO = 0;
	private int numero;
	private Date dateCree;
	private Place place;
	private Client client;

	public Reservation(Date date, Place place, Client client) {
		this.numero = NEXT_NUMERO++;
		this.dateCree = date;
		this.place = place;
	}
	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateCree() {
		return this.dateCree;
	}
	
	public Place getPlace() {
		return this.place;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * 
	 * @param tempsRestant
	 */
	/*public void setTempsRestant(Time tempsRestant) {
		this.tempsRestant = tempsRestant;
	}*/

}