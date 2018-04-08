package driver;

import admin.Administrateur;
import client.Client;
import core.EtatDisponible;
import interfaceVol.AirE;
import interfaceVol.FabriqueEntiteVoyageAvion;
import interfaceVol.SiegeAvion;
import misc.Database;

public class TestSGR {

	public static void main(String[] args) {
		Database db = new Database();
		Administrateur a = new Administrateur(db);
		db.registerObserver(a);
		a.creerCompagnieAerienne("AV123");
		a.creerAeroport("A1242334", "MTL");
		FabriqueEntiteVoyageAvion f = FabriqueEntiteVoyageAvion.getInstance();
		//SiegeAvion sa = new SiegeAvion(1,2,new AirE());
		Client c = new Client(db);
		//c.reserver(sa);
		//System.out.println(sa.getEtat() instanceof EtatDisponible);

	}

}
