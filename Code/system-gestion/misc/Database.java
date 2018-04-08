package misc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.Compagnie;
import core.Itineraire;
import core.Section;
import core.Station;
import interfaceCroisiere.CompagnieCroisiere;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceCroisiere.Port;
import interfaceTrain.Gare;
import interfaceTrain.ItineraireTrain;
import interfaceTrain.LigneTrain;
import interfaceVol.Aeroport;
import interfaceVol.AirE;
import interfaceVol.CompagnieAerienne;
import interfaceVol.SectionAvion;
import interfaceVol.Vol;
import reservation.Reservation;

public class Database implements Subject {

	private HashMap<Integer, Reservation> reservations;
	private HashMap<String, Compagnie> compagnies;
	private HashMap<String, Station> stations;
	private HashMap<String, Itineraire> itineraires;
	private List<Observer> observers;

	public Database() {
		reservations = new HashMap<Integer, Reservation>();
		compagnies = new HashMap<String, Compagnie>();
		stations = new HashMap<String, Station>();
		itineraires = new HashMap<String, Itineraire>();
		observers = new ArrayList<>();
		
		try {
			initializeObjects();
		} catch (ParseException e) {
			e.printStackTrace();
		}				
	}
	
	// Initialize hard-coded objects
	private void initializeObjects() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd:HH:mm");
		
		// Initialize vols 
		Compagnie compAerienne1 = new CompagnieAerienne("AIRCAN");
		Compagnie compAerienne2 = new CompagnieAerienne("JPNAIR");
		Compagnie compAerienne3 = new CompagnieAerienne("AIRFRA");
		compagnies.put(compAerienne1.getId(), compAerienne1);
		compagnies.put(compAerienne2.getId(), compAerienne2);
		compagnies.put(compAerienne3.getId(), compAerienne3);
		
		Station aeroport1 = new Aeroport("YUL", "Montreal");
		Station aeroport2 = new Aeroport("YYZ", "Toronto");
		Station aeroport3 = new Aeroport("HND", "Tokyo");
		Station aeroport4 = new Aeroport("JFK", "New York");
		Station aeroport5 = new Aeroport("ORD", "Chicago");
		stations.put(aeroport1.getId(), aeroport1);
		stations.put(aeroport2.getId(), aeroport2);
		stations.put(aeroport3.getId(), aeroport3);
		stations.put(aeroport4.getId(), aeroport4);
		stations.put(aeroport5.getId(), aeroport5);
		
		List<Station> arrets1 = new ArrayList<Station>();
		arrets1.add(aeroport1);
		arrets1.add(aeroport2);
		Itineraire vol1 = new Vol("AC481", df.parse("2014.11.28:06:00"), df.parse("2014.11.28:07:24"), compAerienne1, arrets1);
		SectionAvion section = new AirE();
		section.setDisposition("S");
		section.setNombreRangees(10);
		vol1.creerSection(section);
		List<Station> arrets2 = new ArrayList<Station>();
		arrets2.add(aeroport3);
		arrets2.add(aeroport4);
		Itineraire vol2 = new Vol("JA502", df.parse("2017.12.01:11:00"), df.parse("2017.12.02:01:00"), compAerienne2, arrets2);
	
		List<Station> arrets3 = new ArrayList<Station>();
		arrets3.add(aeroport5);
		arrets3.add(aeroport1);
		Itineraire vol3 = new Vol("AF100", df.parse("2019.10.10:08:00"), df.parse("2019.10.10:13:00"), compAerienne3, arrets3);
	
		vol1.setPrix(500);
		vol2.setPrix(1323);
		vol3.setPrix(869);
		itineraires.put(vol1.getId(), vol1);
		itineraires.put(vol2.getId(), vol2);
		itineraires.put(vol3.getId(), vol3);

		// Initialize itineraires trains
		Compagnie ligneTrain1 = new LigneTrain("UKRAIL");
		Compagnie ligneTrain2 = new LigneTrain("JPRAIL");
		compagnies.put(ligneTrain1.getId(), ligneTrain1);
		compagnies.put(ligneTrain1.getId(), ligneTrain1);

		Station gare1 = new Gare("BRT", "Brighton");
		Station gare2 = new Gare("BTH", "Bath");
		Station gare3 = new Gare("SLB", "Salisbury");
		Station gare4 = new Gare("LDN", "London");
		Station gare5 = new Gare("TKY", "Tokyo");
		Station gare6 = new Gare("OSK", "Osaka");
		Station gare7 = new Gare("FKK", "Fukuoka");
		Station gare8 = new Gare("OXD", "Oxford");
		
		stations.put(gare1.getId(), gare1);
		stations.put(gare2.getId(), gare2);
		stations.put(gare3.getId(), gare3);
		stations.put(gare4.getId(), gare4);
		stations.put(gare5.getId(), gare5);
		stations.put(gare6.getId(), gare6);
		stations.put(gare7.getId(), gare7);
		stations.put(gare8.getId(), gare8);

		List<Station> garrs1 = new ArrayList<Station>();
		garrs1.add(gare1);
		garrs1.add(gare2);
		garrs1.add(gare3);
		Itineraire itinTrain1 = new ItineraireTrain("BR666", df.parse("2018.01.01:01:00"), df.parse("2018.01.01:09:24"), ligneTrain1,
				garrs1);

		List<Station> garrs2 = new ArrayList<Station>();
		garrs2.add(gare2);
		garrs2.add(gare3);
		garrs2.add(gare4);
		garrs2.add(gare8);
		Itineraire itinTrain2 = new ItineraireTrain("BR544", df.parse("2017.05.01:11:00"), df.parse("2017.05.02:01:01"), ligneTrain1,
				garrs2);

		List<Station> garrs3 = new ArrayList<Station>();
		garrs3.add(gare5);
		garrs3.add(gare6);
		garrs3.add(gare7);
		Itineraire itinTrain3 = new ItineraireTrain("JP900", df.parse("2018.11.10:12:03"), df.parse("2018.11.10:18:05"), ligneTrain2,
				garrs3);

		itinTrain1.setPrix(55);
		itinTrain2.setPrix(122);
		itinTrain3.setPrix(179);
		itineraires.put(itinTrain1.getId(), itinTrain1);
		itineraires.put(itinTrain2.getId(), itinTrain2);
		itineraires.put(itinTrain3.getId(), itinTrain3);
		
		// Initialize itineraires croisieres
		Compagnie compCroisiere1 = new CompagnieCroisiere("DSNCRU");
		Compagnie compCroisiere2 = new CompagnieCroisiere("CARAIB");
		Compagnie compCroisiere3 = new CompagnieCroisiere("MEDITE");
		compagnies.put(compCroisiere1.getId(), compCroisiere1);
		compagnies.put(compCroisiere2.getId(), compCroisiere2);
		compagnies.put(compCroisiere3.getId(), compCroisiere3);

		Station port1 = new Port("PAP", "Port-au-prince");
		Station port2 = new Port("HVN", "Havane");
		Station port3 = new Port("FDF", "Fort-de-France");
		Station port4 = new Port("MAM", "Miami");
		Station port5 = new Port("CMY", "Costa Maya");
		Station port6 = new Port("ALG", "Alger");
		Station port7 = new Port("TUN", "Tunis");
		Station port8 = new Port("MRS", "Marseille");
		
		stations.put(port1.getId(), port1);
		stations.put(port2.getId(), port2);
		stations.put(port3.getId(), port3);
		stations.put(port4.getId(), port4);
		stations.put(port5.getId(), port5);
		stations.put(port6.getId(), port6);
		stations.put(port7.getId(), port7);
		stations.put(port8.getId(), port8);

		List<Station> pors1 = new ArrayList<Station>();
		pors1.add(port1);
		pors1.add(port2);
		pors1.add(port3);
		pors1.add(port1);
		Itineraire itinCroi1 = new ItineraireCroisiere("DS198", df.parse("2018.08.11:11:30"), df.parse("2018.08.20:09:30"), compCroisiere1,
				pors1);

		List<Station> pors2 = new ArrayList<Station>();
		pors2.add(port4);
		pors2.add(port2);
		pors2.add(port3);
		pors2.add(port5);
		pors2.add(port4);
		Itineraire itinCroi2 = new ItineraireCroisiere("CR322", df.parse("2017.03.08:12:00"), df.parse("2017.03.20:13:05"), compCroisiere2,
				pors2);

		List<Station> pors3 = new ArrayList<Station>();
		pors3.add(port8);
		pors3.add(port7);
		pors3.add(port6);
		pors3.add(port8);
		Itineraire itinCroi3 = new ItineraireCroisiere("ME880", df.parse("2018.07.01:12:05"), df.parse("2018.07.10:09:08"), compCroisiere3,
				pors3);

		itinCroi1.setPrix(2599);
		itinCroi1.setPrix(1622);
		itinCroi1.setPrix(1245);
		itineraires.put(itinCroi1.getId(), itinCroi1);
		itineraires.put(itinCroi2.getId(), itinCroi2);
		itineraires.put(itinCroi3.getId(), itinCroi3);
	}
	
	/**
	 * 
	 * @param observer
	 */
	// Idole
		public void registerObserver(Observer observer) {
			if (observer == null) {
				throw new NullPointerException("No observer");
			}
			if (!observers.contains(observer)) {
				observers.add(observer);
			}
		}

		/**
		 * 
		 * @param observer
		 */
		// Idole
		public void unregisterObserver(Observer observer) {
			observers.remove(observer);
		}

		/**
		 * 
		 * @param observer
		 */
		
		// Idole
		@Override
		public void notifyObservers(Reservation reservation) {
			for (Observer o : observers) {
				o.update(reservation);
			}
		}
		// Idole
		@Override
		public void notifyObservers(Compagnie compagnie) {
			for (Observer o : observers) {
				o.update(compagnie);
			}
		}
		
		// Idole
		@Override
		public void notifyObservers(Station station) {
			for (Observer o : observers) {
				o.update(station);
			}
		}
		
		// Idole
		@Override
		public void notifyObservers(Itineraire itineraire) {
			for (Observer o : observers) {
				o.update(itineraire);
			}
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
			notifyObservers(reservation);
			reservations.put(reservation.getNumero(), reservation);
		}

		public void removeReservation(int numero) {
			notifyObservers(reservations.get(numero));
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
			notifyObservers(compagnie);
			compagnies.put(compagnie.getId(), compagnie);
		}
		
		public void removeCompagnie(String id) {
			notifyObservers(compagnies.get(id));
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
			notifyObservers(station);
			stations.put(station.getId(), station);
		}
		
		public void removeStation(String id) {
			notifyObservers(stations.get(id));
			stations.remove(id);
		}

		/**
		 * 
		 * @param ide
		 */
		public Itineraire getItineraire(String id) {
			return itineraires.get(id);
		}

	
	public List<Itineraire> getAllItineraires() {
		List<Itineraire> list = new ArrayList<Itineraire>();
		for(Map.Entry<String, Itineraire> entry : itineraires.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
		/**
		 * 
		 * @param id
		 * @param itineraire
		 */
		public void setItineraire(Itineraire itineraire) {
			notifyObservers(itineraire);
			itineraires.put(itineraire.getId(), itineraire);
		}
		
		public void removeItineraire(String id) {
			notifyObservers(itineraires.get(id));
			itineraires.remove(id);
		}

}