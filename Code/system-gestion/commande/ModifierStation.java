package commande;
import core.FabriqueEntiteVoyage;
import core.Station;
import misc.Database;

public class ModifierStation extends ModifierEntiteVoyage {

	private String newId;
	private String oldId;
	private String newVille;
	private String oldVille;

	/**
	 * 
	 * @param fabrique
	 * @param id
	 * @param ville
	 */
	public ModifierStation(Database db, Station station, String id, String ville) {
		super(db, station);
		this.newId = id;
		this.newVille = ville;
		this.oldId = station.getId();
		this.oldVille = station.getVille();
	}

	public void execute() {
		Station station = (Station) entiteVoyage;
		station.setId(newId);
		station.setVille(newVille);
		
		if(!newId.equalsIgnoreCase(oldId)) {
			db.removeStation(oldId);
			db.setStation(station);
		}
	}

	public void cancel() {
		Station station = (Station) entiteVoyage;
		station.setId(oldId);
		station.setVille(oldVille);
		
		if(!newId.equalsIgnoreCase(newId)) {
			db.removeStation(newId);
			db.setStation(station);
		}
	}

}