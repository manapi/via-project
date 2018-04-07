package admin;
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
import core.Section;
import core.Station;
import interfaceCroisiere.FabriqueEntiteVoyageBateau;
import interfaceCroisiere.SectionPaquebot;
import interfaceTrain.DispoSiegeTrain;
import interfaceTrain.FabriqueEntiteVoyageTrain;
import interfaceTrain.SectionTrain;
import interfaceTrain.TrainE;
import interfaceVol.AirE;
import interfaceVol.AirM;
import interfaceVol.DispoSiegeAvion;
import interfaceVol.FabriqueEntiteVoyageAvion;
import interfaceVol.SectionAvion;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;

public class Administrateur implements Observer, Visitable {

	private Database db;
	private Commande lastCmd;
	
	public Administrateur(Database db) {
		this.db = db;
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
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
}