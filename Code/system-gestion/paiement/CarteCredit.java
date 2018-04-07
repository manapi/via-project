package paiement;
import java.util.Date;

public class CarteCredit extends MethodePaiement {

	private double creditDisponible;
	private double limiteCredit;
	private int numero;
	private Date dateExpiration;
	
	public CarteCredit(int numero, Date dateExpiration, double creditDisponible, double limiteCredit) {
		this.numero = numero;
		this.dateExpiration = dateExpiration;
		this.creditDisponible = creditDisponible;
		this.limiteCredit = limiteCredit;
		
		this.balance = 0;
	}

	/**
	 * 
	 * @param montant
	 */
	public boolean charger(double montant) {
		if(montant <= creditDisponible && balance + montant <= limiteCredit) {
			creditDisponible -= montant;
			balance += montant;
			return true;
		} else return false;
	}

	/**
	 * 
	 * @param montant
	 */
	public void rembourser(double montant) {
		balance -= montant;
		creditDisponible = montant + creditDisponible < limiteCredit ? montant + creditDisponible : limiteCredit;
	}

}