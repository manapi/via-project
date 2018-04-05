public abstract class IdSingleton {

	private instance IdSingleton;
	private String nextId;

	private IdSingleton() {
		// TODO - implement IdSingleton.IdSingleton
		throw new UnsupportedOperationException();
	}

	public IdSingleton getIdSingleton() {
		// TODO - implement IdSingleton.getIdSingleton
		throw new UnsupportedOperationException();
	}

	public abstract String nextId();

}