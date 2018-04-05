public abstract class MethodePaiement {

	protected double balance;

	/**
	 * 
	 * @param montant
	 */
	public abstract void charger(double montant);

	/**
	 * 
	 * @param montant
	 */
	public abstract void rembourser(double montant);

}