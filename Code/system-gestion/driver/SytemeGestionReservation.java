package driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import admin.Administrateur;
import client.Client;
import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Place;
import core.Station;
import interfaceCroisiere.FabriqueEntiteVoyageBateau;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceTrain.FabriqueEntiteVoyageTrain;
import interfaceTrain.Gare;
import interfaceVol.CompagnieAerienne;
import interfaceVol.FabriqueEntiteVoyageAvion;
import misc.Database;

public class SytemeGestionReservation {

	final private static String OPTION_PROMPT = "Entrer le num�ro de l'option choisie : ";
	final private static String DATE_FORMAT = "yyyy.MM.dd:HH:mm";
	private static SimpleDateFormat df;
	private static Scanner scanner;
	private static Client cli;
	private static Administrateur admin;
	
	public static void main(String[] args) {
		
		Database db = new Database();
		cli = new Client(db);
		admin = new Administrateur(db);
		
		// TODO : command line UI
		df = new SimpleDateFormat(DATE_FORMAT);
		scanner = new Scanner(System.in);
		db.registerObserver(cli);
		db.registerObserver(admin);
		boolean running = true;
		
		while(running) {
			System.out.println("1. Vue administrateur");
			System.out.println("2. Vue client");
			System.out.println("3. Quitter");
			System.out.print(OPTION_PROMPT);
			
			int menuType = scanner.nextInt();
			if(!(menuType == 1 || menuType == 2 || menuType == 3)) {
				System.out.print("Invalid option number");
				System.exit(0);
			}

			if (menuType == 1) {
				displayAdminMenu();
			} else if (menuType == 2) {
				displayClientMenu();
			} else if (menuType == 3) {
				running = false;
			}
			System.out.println();
			System.out.println();
		}
		scanner.close();
		
		// TODO : TO REMOVE - temporary tests
		
		// Testing commandes
		/*admin.creerAeroport("AAA", "London");
		System.out.println(db.getStation("AAA").getVille());
		
		/*admin.cancel();
		if(db.getStation("AAA") == null) {
			System.out.println("cancel successful!");
		}*/
		
		/*admin.modifierStation("AAA", "AAA", "Toronto");
		System.out.println(db.getStation("AAA").getVille());
		admin.cancel();
		System.out.println(db.getStation("AAA").getVille());
		
		admin.supprimerStation("AAA");
		if(db.getStation("AAA") == null) {
			System.out.println("Delete successful!");
		}
		admin.cancel();
		System.out.println(db.getStation("AAA").getId());
		admin.creerCompagnieAerienne("CCC");
		List<Station> arrets = new ArrayList<Station>();
		arrets.add(db.getStation("AAA"));
		admin.creerVol("AAA000", new Date(0), new Date(0), "CCC", "AAA", "AAA");
		admin.assignerPrix("AAA000", 100);
		System.out.println(db.getItineraire("AAA000").getPrix());
		admin.cancel();
		System.out.println(db.getItineraire("AAA000").getPrix());
		
		admin.creerSectionAvion("AAA000", "E", "M", 5);
		System.out.println(db.getItineraire("AAA000").getNombrePlaces("E"));
		admin.cancel();
		System.out.println(db.getItineraire("AAA000").getNombrePlaces("E"));*/
	}
	
	private static void displayAdminMenu() {
		System.out.println("Vue administrateur");
		System.out.println("0. Consultation par station");
		System.out.println("1. Consultation par compagnie");
		System.out.println("2. Creer aeroport");
		System.out.println("3. Creer compagnie aerienne");
		System.out.println("4. Creer vol");
		System.out.println("5. Creer section avion");
		System.out.println("6. Creer gare");
		System.out.println("7. Creer ligne de train");
		System.out.println("8. Creer itineraire de train");
		System.out.println("9. Creer section train");
		System.out.println("10. Creer port");
		System.out.println("11. Creer compagnie de croisiere");
		System.out.println("12. Creer itineraire de croisiere");
		System.out.println("13. Creer section paquebot");
		System.out.println("14. Modifier station");
		System.out.println("15.  Modifier compagnie");
		System.out.println("16. Modifier itineraire");
		System.out.println("17. Supprimer station");
		System.out.println("18. Supprimer compagnie");
		System.out.println("19. Supprimer itineraire");
		System.out.println("20. Assigner un prix");
		System.out.println("21. Cancel (annule l'operation precedente)");
		
		System.out.print(OPTION_PROMPT);
		
		String id, ville, compagnie, type, disposition, newId;
		int nbRangees, nbCabines;
		Date dateDepart, dateArrivee;
		List<Itineraire> list;
		try {
			switch (scanner.nextInt()) {
			case 0:
				System.out.print("Id de la station : ");
				list = admin.consulterItinerairesParStation(scanner.next());
				for(Itineraire itin : list) {
					System.out.println(admin.visit(itin));
				}
				break;
			case 1:
				System.out.print("Id de la compagnie : ");
				list = admin.consulterItinerairesParCompagnie(scanner.next());
				for(Itineraire itin : list) {
					System.out.println(admin.visit(itin));
				}
				break;
			case 2:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Ville : ");
				ville = scanner.next();
				admin.creerAeroport(id, ville);
				System.out.print("Aeroport cree!");
				break;
			case 3:
				System.out.print("Id : ");
				admin.creerCompagnieAerienne(scanner.next());
				System.out.print("Compagnie cree!");
				break;
			case 4:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Date depart (" + DATE_FORMAT + ": ");
				dateDepart = df.parse(scanner.next());
				System.out.print("Date arrivee (" + DATE_FORMAT + ": ");
				dateArrivee = df.parse(scanner.next());
				System.out.print("Compagnie aerienne (id) : ");
				compagnie = scanner.next();
				System.out.print("Aeroport de d�part (id) : ");
				String aeroportDepart = scanner.next();
				System.out.print("Aeroport d'arrivee (id) : ");
				String aeroportArrivee = scanner.next();
				admin.creerVol(id, dateDepart, dateArrivee, compagnie, aeroportDepart, aeroportArrivee);
				System.out.print("Vol cree!");
				break;
			case 5:
				System.out.print("Id du vol : ");
				id = scanner.next();
				System.out.print("Type de section (F/A/P/E): ");
				type = scanner.next();
				System.out.print("Disposition (S/C/M/L): ");
				disposition = scanner.next();
				System.out.print("Nombre de rangees : ");
				nbRangees = scanner.nextInt();
				admin.creerSectionAvion(id, type, disposition, nbRangees);
				System.out.print("Section cree!");
				break;
			case 6:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Ville : ");
				ville = scanner.next();
				admin.creerGare(id, ville);
				System.out.print("Gare cree!");
				break;
			case 7:
				System.out.print("Id : ");
				admin.creerLigneTrain(scanner.next());
				System.out.print("Ligne cree!");
				break;
			case 8:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Date depart (" + DATE_FORMAT + ": ");
				dateDepart = df.parse(scanner.next());
				System.out.print("Date arrivee (" + DATE_FORMAT + ": ");
				dateArrivee = df.parse(scanner.next());
				System.out.print("Ligne de train (id) : ");
				compagnie = scanner.next(); 
				scanner.nextLine();
				System.out.print("Gares (ids separes par des espaces) : ");
				String line = scanner.nextLine();
				StringTokenizer tok = new StringTokenizer(line);
				List<String> gares = new ArrayList<String>();
				while (tok.hasMoreTokens()) {
					gares.add(tok.nextToken());
				}
				admin.creerItineraireTrain(id, dateDepart, dateArrivee, compagnie, gares);
				System.out.print("Itineraire de train cree!");
				break;
			case 9:
				System.out.print("Id de l'itineraire : ");
				id = scanner.next();
				System.out.print("Type de section (P/E): ");
				type = scanner.next();
				System.out.print("Disposition (S): ");
				disposition = scanner.next();
				System.out.print("Nombre de rangees : ");
				nbRangees = scanner.nextInt();
				admin.creerSectionTrain(id, type, disposition, nbRangees);
				System.out.print("Section cree!");
				break;
			case 10:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Ville : ");
				ville = scanner.next();
				admin.creerPort(id, ville);
				System.out.print("Port cree!");
				break;
			case 11:
				System.out.print("Id : ");
				admin.creerCompagnieCroisiere(scanner.next());
				System.out.print("Ligne cree!");
				break;
			case 12:
				System.out.print("Id : ");
				id = scanner.next();
				System.out.print("Date depart (" + DATE_FORMAT + ": ");
				dateDepart = df.parse(scanner.next());
				System.out.print("Date arrivee (" + DATE_FORMAT + ": ");
				dateArrivee = df.parse(scanner.next());
				System.out.print("Compagnie de croisiere (id) : ");
				compagnie = scanner.next();
				scanner.nextLine();
				System.out.print("Ports (ids separes par des espaces) : ");
				String line2 = scanner.nextLine();
				StringTokenizer tok2 = new StringTokenizer(line2);
				List<String> ports = new ArrayList<String>();
				while (tok2.hasMoreTokens()) {
					ports.add(tok2.nextToken());
				}
				admin.creerItineraireCroisiere(id, dateDepart, dateArrivee, compagnie, ports);
				System.out.print("Itineraire de croisiere cree!");
				break;
			case 13:
				System.out.print("Id de l'itineraire : ");
				id = scanner.next();
				System.out.print("Type de section (I/O/S/F/D): ");
				type = scanner.next();
				System.out.print("Nombre de cabines : ");
				nbCabines = scanner.nextInt();
				admin.creerSectionPaquebot(id, type, nbCabines);
				System.out.print("Section cree!");
				break;
			case 14:
				System.out.print("Id de la station : ");
				id = scanner.next();
				System.out.print("Nouvel id : ");
				newId = scanner.next();
				System.out.print("Nouvelle ville : ");
				ville = scanner.next();
				admin.modifierStation(id, newId, ville);
				;
				System.out.print("Station modifiee!");
				break;
			case 15:
				System.out.print("Id de la compagnie : ");
				id = scanner.next();
				System.out.print("Nouvel id : ");
				newId = scanner.next();
				admin.modifierCompagnie(id, newId);
				System.out.print("Compagnie modifiee!");
				break;
			case 16:
				System.out.print("Id de l'itineraire : ");
				id = scanner.next();
				System.out.print("Nouvel id : ");
				newId = scanner.next();
				System.out.print("Nouvelle date depart (" + DATE_FORMAT + ": ");
				dateDepart = df.parse(scanner.next());
				System.out.print("Nouvelle date arrivee (" + DATE_FORMAT + ": ");
				dateArrivee = df.parse(scanner.next());
				System.out.print("Nouvelle compagnie (id) : ");
				compagnie = scanner.next();
				System.out.print("Arrets (ids separes par des espaces) : ");
				String line3 = scanner.nextLine();
				StringTokenizer tok3 = new StringTokenizer(line3);
				List<String> arrets = new ArrayList<String>();
				while (tok3.hasMoreTokens()) {
					arrets.add(tok3.nextToken());
				}
				admin.modifierItineraire(id, newId, dateDepart, dateArrivee, compagnie, arrets);
				System.out.print("Itineraire modifiee!");
				break;
			case 17:
				System.out.print("Id de la station : ");
				id = scanner.next();
				admin.supprimerStation(id);
				System.out.print("Station suprimee!");
				break;
			case 18:
				System.out.print("Id de la compagnie : ");
				id = scanner.next();
				admin.supprimerCompagnie(id);
				System.out.print("Compagnie suprimee!");
				break;
			case 19:
				System.out.print("Id de l'itineraire : ");
				id = scanner.next();
				admin.supprimerItineraire(id);
				System.out.print("Itineraire suprimee!");
				break;
			case 20:
				System.out.print("Id de l'itineraire : ");
				id = scanner.next();
				System.out.print("Id de l'itineraire : ");
				double prix = scanner.nextDouble();
				admin.assignerPrix(id, prix);
				System.out.print("Prix assigne!");
				break;
			case 21:
				admin.cancel();
				System.out.print("Action precedente annulee!");
				break;
			default:
				System.out.println("Invalid option");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void displayClientMenu() {
		System.out.println("Vue client");
		System.out.println("0. Consultation");
		System.out.println("1. Reserver une place");
		System.out.println("2. Confirmer une reservation");
		System.out.println("3. Modifier une reservation");
		System.out.println("4. Annuler une reservation");

		System.out.print(OPTION_PROMPT);
		int noReservation;

		try {
			switch (scanner.nextInt()) {
			case 0:
				System.out.print("Station d'origine : ");
				String idOrigine = scanner.next();
				System.out.print("Station de destination : ");
				String idDestination = scanner.next();
				System.out.print("Classe (un caractere) : ");
				String classe = scanner.next();
				List<Itineraire> list = cli.consulterItineraires(idOrigine, idDestination, classe);
				for(Itineraire itin : list) {
					System.out.println(cli.visit(itin));
				}
				break;
			case 1:
				System.out.print("Id de l'itineraire : ");
				String id = scanner.next();
				System.out.print("Classe (un caractere) : ");
				String section = scanner.next();
				List<Place> places = cli.afficherPlacesDisponibles(id, section);
				if(places.isEmpty()) {
					System.out.println("Pas de places disponibles");
				} else {
					cli.reserver(places.get(0));
					System.out.println("Place reservee!");
				}
				break;
			case 2:
				System.out.println("Entrer les informations client :");
				scanner.nextLine();
				System.out.print("Nom :");
				String nom = scanner.nextLine();
				System.out.print("Adresse : ");
				String adresse = scanner.nextLine();
				System.out.print("Courriel :");
				String courriel = scanner.next();
				System.out.print("Telephone :");
				String telephone = scanner.next();
				System.out.print("Date de naissance (" + DATE_FORMAT + ": ");
				Date dateNaissance = df.parse(scanner.next());
				cli.setClientInfo(nom, adresse, courriel, telephone, dateNaissance);

				System.out.print("Numero de passeport :");
				int numero = scanner.nextInt();
				System.out.print("Date d'expiration (" + DATE_FORMAT + ": ");
				Date dateExpiration = df.parse(scanner.next());
				cli.setPasseport(numero, dateExpiration);
				System.out.println("Entrer les informations de paiement : ");

				System.out.print("Numero de carte de credit :");
				numero = scanner.nextInt();
				System.out.print("Date d'expiration (" + DATE_FORMAT + ": ");
				dateExpiration = df.parse(scanner.next());
				System.out.print("Credit disponible :");
				double creditDisponible = scanner.nextDouble();
				System.out.print("Limite de credit :");
				double limiteCredit = scanner.nextDouble();
				cli.setCarteCredit(numero, dateExpiration, creditDisponible, limiteCredit);

				System.out.print("Entrer le numero de la reservation a confirmer : ");
				noReservation = scanner.nextInt();

				if (cli.confirmer(noReservation)) {
					System.out.println("Reservation confirmee!");
				} else {
					System.out.println("Confirmation echouee");
				}
				break;
			case 3:
				System.out.print("Entrer le numero de la reservation : ");
				noReservation = scanner.nextInt();
				System.out.print("Entrer l'id du nouvel itineraire : ");
				id = scanner.next();
				System.out.print("Entrer la classe de la nouvelle place : ");
				section = scanner.next();
				List<Place> nvplaces = cli.afficherPlacesDisponibles(id, section);
				if(nvplaces.isEmpty()) {
					System.out.println("Pas de places disponibles");
				} else {
					cli.modifier(noReservation, nvplaces.get(0));
					System.out.print("Reservation modifiee!");
				}
				break;
			case 4:
				System.out.print("Entrer le numero de la reservation : ");
				cli.annuler(scanner.nextInt());
				System.out.print("Reservation annulee! ");
				break;
			default:
				System.out.println("Invalid option");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}