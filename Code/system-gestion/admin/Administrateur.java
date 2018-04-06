package admin;
import commande.Commande;
import misc.Database;
import misc.Observer;
import misc.Visitable;
import misc.Visitor;

public class Administrateur implements Observer, Visitable {

	private Database db;
	private Commande last_cmd;
	
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
}