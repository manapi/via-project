package driver;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import admin.Administrateur;
import client.Client;
import core.Compagnie;
import core.FabriqueEntiteVoyage;
import core.Itineraire;
import core.Station;
import interfaceCroisiere.FabriqueEntiteVoyageBateau;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceTrain.FabriqueEntiteVoyageTrain;
import interfaceTrain.Gare;
import interfaceVol.CompagnieAerienne;
import interfaceVol.FabriqueEntiteVoyageAvion;
import misc.Database;

public class SytemeGestionReservation {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Database db = new Database();
		Client cli = new Client(db);
		Administrateur admin = new Administrateur(db);
		
		// TODO : command line UI
		
		// TODO : temporary tests
		
		//Testing factories
		/*FabriqueEntiteVoyage fabrique = FabriqueEntiteVoyageAvion.getInstance();
		FabriqueEntiteVoyage fabrique2 = FabriqueEntiteVoyageBateau.getInstance();
		FabriqueEntiteVoyage fabrique3 = FabriqueEntiteVoyageTrain.getInstance();
		if(fabrique!=fabrique3) {
			System.out.println("fabrique singleton working");
		}
		Compagnie compagnie = fabrique.creerCompagnie("AAA");
		if(compagnie instanceof CompagnieAerienne) {
			System.out.println(compagnie.getId());
		}
		Station station = fabrique3.creerStation("AAA", "London");
		if(station instanceof Gare) {
			System.out.println(station.getVille());
		}
		
		List<Station> arrets = new ArrayList<Station>();
		arrets.add(fabrique2.creerStation("BBB", "orange"));
		Itineraire itineraire = fabrique2.creerItineraire("AAA", new Date(0, 0, 0), new Time(0, 0, 0), new Time(0, 0, 0),new Time(0, 0, 0), compagnie, arrets);
		if(itineraire instanceof ItineraireCroisiere) {
			System.out.println(itineraire.getCompagnie().getId());
			System.out.println(itineraire.getArrets().get(0).getVille());
		}*/
		
		// Testing commandes
		admin.creerStation("AAA", "London");
		System.out.println(db.getStation("AAA").getVille());
		
		/*admin.cancel();
		if(db.getStation("AAA") == null) {
			System.out.println("cancel successful!");
		}*/
		
		admin.modifierStation(db.getStation("AAA"), "AAA", "Toronto");
		System.out.println(db.getStation("AAA").getVille());
		admin.cancel();
		System.out.println(db.getStation("AAA").getVille());
		
		admin.supprimerStation(db.getStation("AAA"));
		if(db.getStation("AAA") == null) {
			System.out.println("Delete successful!");
		}
		admin.cancel();
		System.out.println(db.getStation("AAA").getId());
		admin.creerCompagnie("CCC");
		List<Station> arrets = new ArrayList<Station>();
		arrets.add(db.getStation("AAA"));
		admin.creerItineraire("AAA000", new Date(0), new Date(0), db.getCompagnie("CCC"), arrets);
		admin.assignerPrix(db.getItineraire("AAA000"), 100);
		System.out.println(db.getItineraire("AAA000").getPrix());
		admin.cancel();
		System.out.println(db.getItineraire("AAA000").getPrix());
	}

}