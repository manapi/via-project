package core;
public class StationSingleton implements IdSingleton {

	private StationSingleton instance;
	private String nextId;
	
	private StationSingleton() {
		// TODO - implement
		throw new UnsupportedOperationException();
	}
	
	public String nextId() {
		// TODO - implement StationSingleton.nextId
		throw new UnsupportedOperationException();
	}

	@Override
	public IdSingleton getIdSingleton() {
		// TODO Auto-generated method stub
		return null;
	}

}