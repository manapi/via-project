package admin;
import java.util.Date;
import java.util.List;

import commande.AssignerPrix;
import commande.Commande;
import commande.CreerCompagnie;
import commande.CreerItineraire;
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
import core.Station;
import interfaceVol.FabriqueEntiteVoyageAvion;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;

public class Administrateur implements Observer, Visitable {

	private Database db;
	private Commande lastCmd;
	private FabriqueEntiteVoyage fabrique;
	
	public Administrateur(Database db) {
		this.db = db;
		this.fabrique = FabriqueEntiteVoyageAvion.getInstance();
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
	public void creerCompagnie(String id) {
		lastCmd = new CreerCompagnie(db, fabrique, id);
		lastCmd.execute();
	}
	
	public void creerStation(String id, String ville) {
		lastCmd = new CreerStation(db, fabrique, id, ville);
		lastCmd.execute();
	}
	
	public void creerItineraire(String id, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		lastCmd = new CreerItineraire(db, fabrique, id, dateDepart, dateArrivee, compagnie, arrets);
		lastCmd.execute();
	}
	
	public void modifierCompagnie(Compagnie compagnie, String newId) {
		lastCmd = new ModifierCompagnie(db, compagnie, newId);
		lastCmd.execute();
	}
	
	public void modifierStation(Station station, String id, String ville) {
		lastCmd = new ModifierStation(db, station, id, ville);
		lastCmd.execute();
	}
	
	public void modifierItineraire(Itineraire itineraire, String newId, Date dateDepart, Date dateArrivee, Compagnie compagnie, List<Station> arrets) {
		lastCmd = new ModifierItineraire(db, itineraire, newId, dateDepart, dateArrivee, compagnie, arrets);
		lastCmd.execute();
	}
	
	public void supprimerCompagnie(Compagnie compagnie) {
		lastCmd = new SupprimerCompagnie(db, compagnie);
		lastCmd.execute();
	}
	
	public void supprimerStation(Station station) {
		lastCmd = new SupprimerStation(db, station);
		lastCmd.execute();
	}
	
	public void supprimerItineraire(Itineraire itineraire) {
		lastCmd = new SupprimerItineraire(db, itineraire);
		lastCmd.execute();
	}
	
	public void assignerPrix(Itineraire itineraire, double prix) {
		lastCmd = new AssignerPrix(itineraire, prix);
		lastCmd.execute();
	}
	
	public void cancel() {
		if(lastCmd != null) {
			lastCmd.cancel();
			lastCmd = null;
		}
	}
}