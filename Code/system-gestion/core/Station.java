package core;

import misc.Visitable;

public abstract class Station extends EntiteVoyage implements Visitable {

	protected String ville;

	public Station(String id, String ville) {
		super(id);
		this.ville = ville;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}