package core;

import misc.Visitable;

public abstract class Compagnie extends EntiteVoyage implements Visitable {
	public Compagnie(String id) {
		super(id);
	}
}