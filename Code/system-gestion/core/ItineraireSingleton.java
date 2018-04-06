package core;
public class ItineraireSingleton implements IdSingleton {

	private ItineraireSingleton instance;
	private String nextId;
	
	private ItineraireSingleton() {
		// TODO - implement
		throw new UnsupportedOperationException();
	}
	
	public String nextId() {
		// TODO - implement ItineraireSingleton.nextId
		throw new UnsupportedOperationException();
	}

	@Override
	public IdSingleton getIdSingleton() {
		// TODO Auto-generated method stub
		return null;
	}

}