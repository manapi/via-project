package client;
import java.util.*;

import core.Place;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;
import paiement.CarteCredit;
import reservation.Reservation;

public class Client implements Observer, Visitor, Visitable {

	Passeport passeport;
	CarteCredit carteCredit;
	private String nom;
	private String adresse;
	private String courriel;
	private String telephone;
	private Date dateNaissance;
	
	private Database db;
	
	public Client(Database db) {
	  this.db = db;
	}
	
	public void setClientInfo(String nom, String adresse, String courriel, String telephone, Date dateNaissance) {
		this.nom = nom;
		this.adresse = adresse;
		this.courriel = courriel;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}
	
	public void setPasseport(int numero,Date dateExpiration) {
		this.passeport = new Passeport(numero, dateExpiration);
	}
	
	public void setCarteCredit(int numero, Date dateExpiration, double creditDisponible, double limiteCredit) {
		this.carteCredit = new CarteCredit(numero, dateExpiration, creditDisponible, limiteCredit);
	}

	/**
	 * 
	 * @param place
	 */
	public int reserver(Place place) {
		// TODO : check if place disponible
		Reservation reservation = new Reservation(new Date(), place);
		// TODO : set place reserve
		db.setReservation(reservation);
		return reservation.getNumero();
	}

	/**
	 * 
	 * @param reservation
	 */
	public boolean confirmer(int noReservation) {
		
		Reservation reservation = db.getReservation(noReservation);
		double montant = reservation.getPlace().getPrix();
		boolean isPaid = carteCredit.charger(montant);
		if(isPaid) {
			//TODO : set place confirme
		}
		return isPaid;

	}

	/**
	 * 
	 * @param reservation
	 */
	public void modifier(int noReservation, Place newPlace) {
		
		Reservation reservation = db.getReservation(noReservation);
		if(true /*siege confirme*/) {
			// adjust payment
		} 
		reservation.setPlace(newPlace);
		// TODO - update place etat
	}

	/**
	 * 
	 * @param parameter
	 */
	public void annuler(int noReservation) {
		
		Reservation reservation = db.getReservation(noReservation);
		if(true /*siege confirme*/) {
			carteCredit.rembourser(reservation.getPlace().getPrix()*0.90);
		}
		//TODO : set siege disponible
		db.removeReservation(noReservation);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTrajet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitCompagnie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitSiege() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}

}