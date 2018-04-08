package client;
import java.text.SimpleDateFormat;
import java.util.*;

import core.Itineraire;
import core.Place;
import core.Section;
import core.Compagnie;
import core.EtatConfirme;
import core.EtatDisponible;
import core.EtatReserve;
import core.Itineraire;
import core.Place;
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
		
		Reservation reservation = null;
		if (place.getEtat() instanceof EtatDisponible) {
			reservation = new Reservation(new Date(), place, this);
			db.setReservation(reservation);
			EtatReserve etatReserve = new EtatReserve();
			etatReserve.setEtat(place);
			reservation.setPlace(place);
		}
		try {
			return reservation.getNumero();
		} catch(NullPointerException e) {
			System.out.println("La place choisie est déjà réservée.");
			return 0;
		}
	}

	/**
	 * 
	 * @param reservation
	 */
	public boolean confirmer(int noReservation) {
		
		Boolean isPaid = false;
		Reservation reservation = db.getReservation(noReservation);
		// Verifie si la reservation est dans la base de donnees et si la place est reservee
		if(reservation != null && reservation.getPlace().getEtat() instanceof EtatReserve) {
			// adjust payment
			double montant = reservation.getPlace().getPrix();
			isPaid = carteCredit.charger(montant);
			if(isPaid) {
				EtatConfirme etatConfirm = new EtatConfirme();
				etatConfirm.setEtat(reservation.getPlace());
				reservation.setPlace(reservation.getPlace());
			}
		} 
		return isPaid;

	}

	/**
	 * 
	 * @param reservation
	 */
	public void modifier(int noReservation, Place newPlace) {
		
		Reservation reservation = db.getReservation(noReservation);
		// Verifie si la reservation est dans la base de donnees et si la place est confirmee
		if(reservation != null && reservation.getPlace().getEtat() instanceof EtatConfirme) {
			// adjust payment
			double oldPrix = reservation.getPlace().getPrix();
			double newPrix = newPlace.getPrix();
			double montant = Math.abs(newPrix-oldPrix);
			if (newPrix > oldPrix) {
				carteCredit.charger(montant);
			}
			else if (newPrix < oldPrix){
				carteCredit.rembourser(montant);
			}
			EtatConfirme etatConfirme = new EtatConfirme();
			etatConfirme.setEtat(newPlace);
			reservation.setPlace(newPlace);
		}
		// Verifie si la reservation est dans la base de donnees et si la place est reservee
		else if (reservation != null && reservation.getPlace().getEtat() instanceof EtatReserve) {
			EtatReserve etatReserve = new EtatReserve();
			etatReserve.setEtat(newPlace);
			reservation.setPlace(newPlace);
		}
	}

	/**
	 * 
	 * @param parameter
	 */
	public void annuler(int noReservation) {
		
		Reservation reservation = db.getReservation(noReservation);
		// Verifie si la reservation est dans la base de donnees et si la place est confirmee
		if(reservation != null && reservation.getPlace().getEtat() instanceof EtatConfirme) {
			carteCredit.rembourser(reservation.getPlace().getPrix()*0.90);
			EtatDisponible etatDispo = new EtatDisponible();
			etatDispo.setEtat(db.getReservation(noReservation).getPlace());
			db.removeReservation(noReservation);
		}
		// Verifie si la reservation est dans la base de donnees et si la place est reservee
		else if (reservation != null && reservation.getPlace().getEtat() instanceof EtatReserve) {
			EtatDisponible etatDispo = new EtatDisponible();
			etatDispo.setEtat(db.getReservation(noReservation).getPlace());
			db.removeReservation(noReservation);
		}
	}

	public void update(Reservation reservation) {
		
		Reservation oldReservation = db.getReservation(reservation.getNumero());
		// Verifie si la nouvelle reservation est dans la base de donnees et si elle appartient au client
		if (oldReservation != null && reservation.getClient().equals(this)) {
			Place newPlace = reservation.getPlace();
			if (newPlace.getEtat() instanceof EtatConfirme && oldReservation.getPlace().getEtat() instanceof EtatReserve) {
				System.out.println("Votre réservation "+reservation.getNumero()+" a été confirmée.");
			}
			else if (newPlace.getEtat() instanceof EtatConfirme) {
				System.out.println("Votre réservation "+reservation.getNumero()+" a été modifiée.");
			}
			else {
				System.out.println("Votre réservation "+reservation.getNumero()+" a été annulée.");
			}
			db.setReservation(reservation);
		}
		// Si la reservation n'est pas dans la base de donnee, on ajoute une reservation pour le client
		else if (reservation.getClient().equals(this)) {
			System.out.println("Votre réservation a été ajoutée. Voici votre numéro de réservation: "+reservation.getNumero());
			//db.setReservation(reservation);
		}
	}
	
	@Override
	public void update(Compagnie compagnie) {
		//db.setCompagnie(compagnie);
	}
	
	@Override
	public void update(Station station) {
		//db.setStation(station);
	}
	
	@Override
	public void update(Itineraire itineraire) {
		//db.setItineraire(itineraire);
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