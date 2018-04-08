package admin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import commande.AssignerPrix;
import commande.Commande;
import commande.CreerCompagnie;
import commande.CreerItineraire;
import commande.CreerSection;
import commande.CreerStation;
import commande.ModifierCompagnie;
import commande.ModifierItineraire;
import commande.ModifierStation;
import commande.SupprimerCompagnie;
import commande.SupprimerItineraire;
import commande.SupprimerStation;
import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Place;
import core.Section;
import core.Station;
import interfaceCroisiere.Cabine;
import interfaceCroisiere.FabriqueEntiteVoyageBateau;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceCroisiere.SectionPaquebot;
import interfaceTrain.DispoSiegeTrain;
import interfaceTrain.FabriqueEntiteVoyageTrain;
import interfaceTrain.ItineraireTrain;
import interfaceTrain.SectionTrain;
import interfaceTrain.SiegeTrain;
import interfaceTrain.TrainE;
import interfaceVol.AirE;
import interfaceVol.AirM;
import interfaceVol.DispoSiegeAvion;
import interfaceVol.FabriqueEntiteVoyageAvion;
import interfaceVol.SectionAvion;
import interfaceVol.SiegeAvion;
import interfaceVol.Vol;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;
import reservation.Reservation;

public class Administrateur implements Observer, Visitor {

	private Database db;
	private Commande lastCmd;
	
	public Administrateur(Database db) {
		this.db = db;
	}

	// Idole
		@Override
		public void update(Reservation reservation) {
			// Verifie si la reservation existe dans la base de donnees
			if (db.getReservation(reservation.getNumero()) != null) {
				if (reservation.equals(db.getReservation(reservation.getNumero()))) {
					System.out.println("La réservation "+reservation.getNumero()+" a été modifiée.");
				}
				else {
					System.out.println("La réservation "+reservation.getNumero()+" a été annulée.");
				}
			}
			else {
				System.out.println("La réservation "+reservation.getNumero()+" a été ajoutée.");
			}
			//db.setReservation(reservation);
		}
	
		// Idole
		@Override
		public void update(Compagnie compagnie) {
			// Verifie si la compagnie existe dans la base de donnees
			if (db.getCompagnie(compagnie.getId()) != null) {
				if (compagnie.equals(db.getCompagnie(compagnie.getId()))) {
					System.out.println("La compagnie "+compagnie.getId()+" a été modifiée.");
				}
				else {
					System.out.println("La compagnie "+compagnie.getId()+" a été supprimée.");
				}
			}
			else {
				System.out.println("La compagnie "+compagnie.getId()+" a été ajoutée.");
			}
			//db.setCompagnie(compagnie);
		}
		
		// Idole
		@Override
		public void update(Station station) {
			// Verifie si la station existe dans la base de donnees
			if (db.getStation(station.getId()) != null) {
				if (station.equals(db.getStation(station.getId()))) {
					System.out.println("La station "+station.getId()+" a été modifiée.");
				}
				else {
					System.out.println("La station "+station.getId()+" a été supprimée.");
				}
			}
			else {
				System.out.println("La station "+station.getId()+" a été ajoutée.");
			}
			//db.setStation(station);
		}
		
		// Idole
		@Override
		public void update(Itineraire itineraire) {
			// Verifie si l'itineraire existe dans la base de donnees
			if (db.getItineraire(itineraire.getId()) != null) {
				if (itineraire.equals(db.getItineraire(itineraire.getId()))) {
					System.out.println("L'itineraire "+itineraire.getId()+" a été modifié.");
				}
				else {
					System.out.println("L'itineraire "+itineraire.getId()+" a été supprimé.");
				}
			}
			else {
				System.out.println("L'itineraire "+itineraire.getId()+" a été ajouté.");
			}
			//db.setItineraire(itineraire);
		}
		
		public String consulterItinerairesParCompagnie(String compagnie) {
			sb = new StringBuilder();
			for(Itineraire itin : db.getAllItineraires()) {
				if(itin.getCompagnie().getId().equalsIgnoreCase(compagnie)) {
					visit(itin);
				}
			}
			return sb.toString();
		}
		
		public String consulterItinerairesParStation(String station) {
			sb = new StringBuilder();
			for(Itineraire itin : db.getAllItineraires()) {
				for(Station arret : itin.getArrets()) {
					if(arret.getId().equalsIgnoreCase(station)) {
						visit(itin);
						break;
					}
				}
			}
			return sb.toString();
		}
		
	public void creerCompagnieAerienne(String id) {
		lastCmd = new CreerCompagnie(db, FabriqueEntiteVoyageAvion.getInstance(), id);
		lastCmd.execute();
	}
	
	public void creerLigneTrain(String id) {
		lastCmd = new CreerCompagnie(db, FabriqueEntiteVoyageTrain.getInstance(), id);
		lastCmd.execute();
	}
	
	public void creerCompagnieCroisiere(String id) {
		lastCmd = new CreerCompagnie(db, FabriqueEntiteVoyageBateau.getInstance(), id);
		lastCmd.execute();
	}
	
	public void creerAeroport(String id, String ville) {
		lastCmd = new CreerStation(db, FabriqueEntiteVoyageAvion.getInstance(), id, ville);
		lastCmd.execute();
	}
	
	public void creerGare(String id, String ville) {
		lastCmd = new CreerStation(db, FabriqueEntiteVoyageTrain.getInstance(), id, ville);
		lastCmd.execute();
	}
	
	public void creerPort(String id, String ville) {
		lastCmd = new CreerStation(db, FabriqueEntiteVoyageBateau.getInstance(), id, ville);
		lastCmd.execute();
	}
	
	public void creerVol(String id, Date dateDepart, Date dateArrivee, String compagnie, String aeroportDepart, String aeroportArrivee) {
		List<Station> arrets = new ArrayList<Station>();
		arrets.add(db.getStation(aeroportDepart));
		arrets.add(db.getStation(aeroportArrivee));
		lastCmd = new CreerItineraire(db, FabriqueEntiteVoyageAvion.getInstance(), id, dateDepart, dateArrivee, db.getCompagnie(compagnie), arrets);
		lastCmd.execute();
	}
	
	public void creerItineraireTrain(String id, Date dateDepart, Date dateArrivee, String compagnie, List<String> gares) {
		List<Station> arrets = new ArrayList<Station>();
		for(String gare : gares) {
			arrets.add(db.getStation(gare));
		}
		lastCmd = new CreerItineraire(db, FabriqueEntiteVoyageTrain.getInstance(), id, dateDepart, dateArrivee, db.getCompagnie(compagnie), arrets);
		lastCmd.execute();
	}
	
	public void creerItineraireCroisiere(String id, Date dateDepart, Date dateArrivee, String compagnie, List<String> ports) {
		List<Station> arrets = new ArrayList<Station>();
		for(String port : ports) {
			arrets.add(db.getStation(port));
		}
		lastCmd = new CreerItineraire(db, FabriqueEntiteVoyageBateau.getInstance(), id, dateDepart, dateArrivee, db.getCompagnie(compagnie), arrets);
		lastCmd.execute();
	}
	
	public void creerSectionAvion(String idVol, String type, String disposition, int nbRangees) {
		SectionAvion sec = (SectionAvion)FabriqueEntiteVoyageAvion.getInstance().creerSection(type);
		sec.setDisposition(disposition);
		sec.setNombreRangees(nbRangees);
		lastCmd = new CreerSection(db.getItineraire(idVol), sec);
		lastCmd.execute();
	}
	
	public void creerSectionTrain(String idTrain, String type, String disposition, int nbRangees) {
		SectionTrain sec = (SectionTrain)FabriqueEntiteVoyageTrain.getInstance().creerSection(type);
		sec.setDisposition(disposition);
		sec.setNombreRangees(nbRangees);
		lastCmd = new CreerSection(db.getItineraire(idTrain), sec);
		lastCmd.execute();
	}
	
	public void creerSectionPaquebot(String idCroisiere, String type, int nbCabines) {
		SectionPaquebot sec = (SectionPaquebot)FabriqueEntiteVoyageBateau.getInstance().creerSection(type);
		sec.setNombreCabines(nbCabines);
		lastCmd = new CreerSection(db.getItineraire(idCroisiere), sec);
		lastCmd.execute();
	}
	
	public void modifierCompagnie(String id, String newId) {
		lastCmd = new ModifierCompagnie(db, db.getCompagnie(id), newId);
		lastCmd.execute();
	}
	
	public void modifierStation(String id, String newId, String ville) {
		lastCmd = new ModifierStation(db, db.getStation(id), newId, ville);
		lastCmd.execute();
	}
	
	public void modifierItineraire(String id, String newId, Date dateDepart, Date dateArrivee, String compagnie, List<String> newArrets) {
		List<Station> arrets = new ArrayList<Station>();
		for(String arr : newArrets) {
			arrets.add(db.getStation(arr));
		}
		lastCmd = new ModifierItineraire(db, db.getItineraire(id), newId, dateDepart, dateArrivee, db.getCompagnie(compagnie), arrets);
		lastCmd.execute();
	}
	
	public void supprimerCompagnie(String id) {
		lastCmd = new SupprimerCompagnie(db, db.getCompagnie(id));
		lastCmd.execute();
	}
	
	public void supprimerStation(String id) {
		lastCmd = new SupprimerStation(db, db.getStation(id));
		lastCmd.execute();
	}
	
	public void supprimerItineraire(String id) {
		lastCmd = new SupprimerItineraire(db, db.getItineraire(id));
		lastCmd.execute();
	}
	
	public void assignerPrix(String id, double prix) {
		lastCmd = new AssignerPrix(db.getItineraire(id), prix);
		lastCmd.execute();
	}
	
	public void cancel() {
		if(lastCmd != null) {
			lastCmd.cancel();
			lastCmd = null;
		}
	}


	//Patron de visiteur:
		public String affichageAvion="";
		public String affichageTrain="";
		public String affichageBateau="";
		public String section="";
		public String disposition="";
		public String prix="";
		public String rapport="";
		StringBuilder sb;
		
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
			for(Section section : itineraire.getSectionList()) {
				sb.append("|" + section.getTypeDispo() + "(");
				sb.append(itineraire.getNombrePlaces(section.getType()) - itineraire.getPlacesDisponibles(section.getType()).size());
				sb.append("/" + itineraire.getNombrePlaces(section.getType()) + ")");
				sb.append(itineraire.getPrixSection(section.getType()));
			}
			sb.append("\n");
		}
		
		
		@Override
		public void visit(Vol vol) {
			affichageAvion=affichageAvion+(vol.getArrets())+":"+"["+(vol.getCompagnie())+"]"+(vol.getId())+"("+(vol.getDateDepart())+"-"+(vol.getDateArrivee())+")";
			//section=""+(vol.getSection());
			List<Place> tempList=vol.getPlacesDisponibles(section);
			int siegesReserves=vol.getNombrePlaces(section) - tempList.size();
			rapport="("+(siegesReserves)+"/"+(vol.getNombrePlaces(section))+")";
		}

		@Override
		public void visit(ItineraireTrain itineraireTrain) {
			affichageTrain=affichageTrain+(itineraireTrain.getArrets())+":"+"["+(itineraireTrain.getCompagnie())+"]"+(itineraireTrain.getId())+"("+(itineraireTrain.getDateDepart())+"-"+(itineraireTrain.getDateArrivee())+")";
			//section=""+(itineraireTrain.getSection());
			List<Place> tempList=itineraireTrain.getPlacesDisponibles(section);
			int siegesReserves=itineraireTrain.getNombrePlaces(section) - tempList.size();
			rapport="("+(siegesReserves)+"/"+(itineraireTrain.getNombrePlaces(section))+")";
		}

		@Override
		public void visit(ItineraireCroisiere itineraireCroisiere) {
			affichageBateau=affichageBateau+(itineraireCroisiere.getArrets())+":"+"["+(itineraireCroisiere.getCompagnie())+"]"+(itineraireCroisiere.getId())+"("+(itineraireCroisiere.getDateDepart())+"-"+(itineraireCroisiere.getDateArrivee())+")";
			//section=""+(itineraireCroisiere.getSection());
			List<Place> tempList=itineraireCroisiere.getPlacesDisponibles(section);
			int siegesReserves=itineraireCroisiere.getNombrePlaces(section) - tempList.size();
			rapport="("+(siegesReserves)+"/"+(itineraireCroisiere.getNombrePlaces(section))+")";
		}
		
//		@Override
//		public void visit(SiegeAvion siegeAvion) {
//			section=section+(siegeAvion.getSection());
//		}
//
//		@Override
//		public void visit(Cabine cabine) {
//			section=section+(cabine.getSection());
//		}
//
//		@Override
//		public void visit(SiegeTrain siegeTrain) {
//			section=section+(siegeTrain.getSection());
//		}

		@Override
		public void visit(SectionAvion sectionAvion) {
			disposition=disposition+(sectionAvion.getDisposition());;
			prix=prix+(sectionAvion.getPourcentageTarif());

		}

		@Override
		public void visit(SectionTrain sectionTrain) {
			disposition=disposition+(sectionTrain.getDisposition());
			prix=prix+(sectionTrain.getPourcentageTarif());
		}

		@Override
		public void visit(SectionPaquebot sectionPaquebot) {
			prix=prix+(sectionPaquebot.getPourcentageTarif());
		}
		
}