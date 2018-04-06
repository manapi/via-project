package core;
public class CompagnieSingleton implements IdSingleton {

	private CompagnieSingleton instance;
	private String nextId;
	
	private CompagnieSingleton() {
		// TODO - implement
		throw new UnsupportedOperationException();
	}
	
	public String nextId() {
		// TODO - implement CompagnieSingleton.nextId
		throw new UnsupportedOperationException();
	}

	@Override
	public IdSingleton getIdSingleton() {
		// TODO Auto-generated method stub
		return null;
	}

}