package driver;

import admin.Administrateur;
import client.Client;
import misc.Database;

public class SytemeGestionReservation {

	/**
	 * 
	 * @param args
	 */
	public void main(String[] args) {

		Database db = new Database();
		Client cli = new Client(db);
		Administrateur admin = new Administrateur(db);
		
		// TODO : command line UI
	}

}