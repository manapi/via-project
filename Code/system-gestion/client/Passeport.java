package client;
import java.util.Date;

public class Passeport {

	private int numero;
	private Date dateExpiration;
	
	public Passeport(int numero, Date dateExpiration) {
		this.numero = numero;
		this.dateExpiration = dateExpiration;
	}

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

	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	/**
	 * 
	 * @param dateExpiration
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

}