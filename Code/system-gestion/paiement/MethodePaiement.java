package paiement;
public abstract class MethodePaiement {

	protected double balance;

	/**
	 * 
	 * @param montant
	 */
	public abstract boolean charger(double montant);

	/**
	 * 
	 * @param montant
	 */
	public abstract void rembourser(double montant);

}