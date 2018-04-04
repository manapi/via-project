public class Reservation {

	private int numero;
	private Time tempsRestant;

	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Time getTempsRestant() {
		return this.tempsRestant;
	}

	/**
	 * 
	 * @param tempsRestant
	 */
	public void setTempsRestant(Time tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

}