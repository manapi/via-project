package client;
import java.util.*;

import core.Place;
import interfaceCroisiere.Cabine;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceCroisiere.SectionPaquebot;
import interfaceTrain.ItineraireTrain;
import interfaceTrain.SectionTrain;
import interfaceTrain.SiegeTrain;
import interfaceVol.SectionAvion;
import interfaceVol.SiegeAvion;
import interfaceVol.Vol;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;
import paiement.CarteCredit;
import reservation.Reservation;

public class Client implements Observer, Visitor {

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

	

//	
//
//	public void visitTrajet() {
//		// TODO 
//		
//	}
//
//	public void visitCompagnie() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void visitSiege() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	//Patron de visiteur:
	public String affichageAvion;
	public String affichageTrain;
	public String affichageBateau;
	public String section;
	public String disposition;
	public String prix;
	public String quantiteDispo;

	@Override
	public void visit(Vol vol) {
		affichageAvion=""+(vol.getArrets())+":"+"["+(vol.getCompagnie())+"]"+(vol.getId())+"("+(vol.getDateDepart())+"-"+(vol.getDateArrivee())+")";
		section=""+(vol.getSection());
		List<Place> tempList=vol.getPlacesDisponibles(section);
		quantiteDispo=""+(tempList.size());
		
	}

	@Override
	public void visit(ItineraireTrain itineraireTrain) {
		affichageTrain=""+(itineraireTrain.getArrets())+":"+"["+(itineraireTrain.getCompagnie())+"]"+(itineraireTrain.getId())+"("+(itineraireTrain.getDateDepart())+"-"+(itineraireTrain.getDateArrivee())+")";
		section=""+(itineraireTrain.getSection());
		List<Place> tempList=itineraireTrain.getPlacesDisponibles(section);
		quantiteDispo=""+ (tempList.size());
	}

	@Override
	public void visit(ItineraireCroisiere itineraireCroisiere) {
		affichageBateau=""+(itineraireCroisiere.getArrets())+":"+"["+(itineraireCroisiere.getCompagnie())+"]"+(itineraireCroisiere.getId())+"("+(itineraireCroisiere.getDateDepart())+"-"+(itineraireCroisiere.getDateArrivee())+")";
		section=""+(itineraireCroisiere.getSection());
		List<Place> tempList=itineraireCroisiere.getPlacesDisponibles(section);
		quantiteDispo=""+ (tempList.size());
	}
	
	
//	@Override
//	public void visit(SiegeAvion siegeAvion) {
//		section=section+(siegeAvion.getSection());
//	}
//
//	@Override
//	public void visit(Cabine cabine) {
//		section=section+(cabine.getSection());
//	}
//
//	@Override
//	public void visit(SiegeTrain siegeTrain) {
//		section=section+(siegeTrain.getSection());
//	}

	@Override
	public void visit(SectionAvion sectionAvion) {
		disposition=""+(sectionAvion.getDisposition());;
		prix=""+(sectionAvion.getPourcentageTarif());

	}

	@Override
	public void visit(SectionTrain sectionTrain) {
		disposition=""+(sectionTrain.getDisposition());
		prix=""+(sectionTrain.getPourcentageTarif());
	}

	@Override
	public void visit(SectionPaquebot sectionPaquebot) {
		prix=""+(sectionPaquebot.getPourcentageTarif());
	}
	

}