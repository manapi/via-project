package client;
import java.util.*;

import core.Passeport;
import core.Place;
import core.Visitable;
import misc.Observer;
import misc.Visitor;
import paiement.CarteCredit;
import reservation.Reservation;

public class Client implements Observer, Visitor, Visitable {

	Passeport passeport;
	Collection<CarteCredit> carteCredit;
	private String nom;
	private String adresse;
	private String courriel;
	private String telephone;
	private Date dateNaissance;

	/**
	 * 
	 * @param place
	 */
	public void reserver(Place place) {
		// TODO - implement Client.reserver
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservation
	 */
	public void confirmer(Reservation reservation) {
		// TODO - implement Client.confirmer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservation
	 */
	public void modifier(Reservation reservation) {
		// TODO - implement Client.modifier
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param parameter
	 */
	public void annuler(Reservation parameter) {
		// TODO - implement Client.annuler
		throw new UnsupportedOperationException();
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