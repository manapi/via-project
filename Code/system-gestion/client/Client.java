package client;
import java.text.SimpleDateFormat;
import java.util.*;

import core.Itineraire;
import core.Place;
import core.Section;
import core.Station;
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
	
	public String consulterItineraires(String origine, String destination, String section) {
		sb = new StringBuilder();

		for(Itineraire itin : db.getAllItineraires()) {
			boolean passByOrigin = false;
			boolean passByDestination = false;
			for(Station arret : itin.getArrets()) {
				if(arret.getId().equalsIgnoreCase(origine)) {
					passByOrigin = true;
				}
				if(passByOrigin && arret.getId().equalsIgnoreCase(destination)) {
					passByDestination = true;
				}
			}
			if(passByOrigin && passByDestination && !itin.getPlacesDisponibles(section).isEmpty()) {
				visit(itin);
				visit(itin, section);
			}
		}
		return sb.toString();
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
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	//Patron de visiteur:
	StringBuilder sb;
	
	public String affichageAvion;
	public String affichageTrain;
	public String affichageBateau;
	public String section;
	public String disposition;
	public String prix;
	public String quantiteDispo;

	
	@Override
	public void visit(Itineraire itineraire) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd:HH:mm");
		List<Station> stations = itineraire.getArrets();
		for(int i=0; i<stations.size(); i++) {
			sb.append(stations.get(i).getId());
			if(i<stations.size()-1) {
				sb.append("-");
			}
		}
		sb.append(":[" + itineraire.getCompagnie().getId() + "]" + itineraire.getId() + "(" + df.format(itineraire.getDateDepart()) 
		+ "-" + df.format(itineraire.getDateArrivee()) + ")");
	}
	
	public void visit(Itineraire itineraire, String type) {
		for(Section section : itineraire.getSectionList()) {
			if(section.getType().equalsIgnoreCase(type)) {
				sb.append("|" + itineraire.getPrixSection(type));
				sb.append("|" + section.getType() + itineraire.getPlacesDisponibles(section.getType()).size());
			}
		}
		sb.append("\n");
	}
	
	
	@Override
	public void visit(Vol vol) {
		//sb.append((vol.getArrets())+":"+"["+(vol.getCompagnie())+"]"+(vol.getId())+"("+(vol.getDateDepart())+"-"+(vol.getDateArrivee())+")")
		
		//affichageAvion=""+(vol.getArrets())+":"+"["+(vol.getCompagnie())+"]"+(vol.getId())+"("+(vol.getDateDepart())+"-"+(vol.getDateArrivee())+")";
		for(Section section : vol.getSectionList()) {
			visit((SectionAvion)section);
			quantiteDispo=""+(vol.getPlacesDisponibles(section.getType()).size());
		}

		
	}

	@Override
	public void visit(ItineraireTrain itineraireTrain) {
		affichageTrain=""+(itineraireTrain.getArrets())+":"+"["+(itineraireTrain.getCompagnie())+"]"+(itineraireTrain.getId())+"("+(itineraireTrain.getDateDepart())+"-"+(itineraireTrain.getDateArrivee())+")";
		//section=""+(itineraireTrain.getSection());
		List<Place> tempList=itineraireTrain.getPlacesDisponibles(section);
		quantiteDispo=""+ (tempList.size());
	}

	@Override
	public void visit(ItineraireCroisiere itineraireCroisiere) {
		affichageBateau=""+(itineraireCroisiere.getArrets())+":"+"["+(itineraireCroisiere.getCompagnie())+"]"+(itineraireCroisiere.getId())+"("+(itineraireCroisiere.getDateDepart())+"-"+(itineraireCroisiere.getDateArrivee())+")";
		//section=""+(itineraireCroisiere.getSection());
		List<Place> tempList=itineraireCroisiere.getPlacesDisponibles(section);
		quantiteDispo=""+ (tempList.size());
	}

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