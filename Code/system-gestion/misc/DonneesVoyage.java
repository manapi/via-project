package misc;
import java.sql.Time;
import java.util.Date;

public abstract class DonneesVoyage{

	protected String idTrajet;
	protected String idCompagnie;
	protected String villeDepart;
	protected String villeArrivee;
	protected Date dateDepart;
	protected Date dateArrivee;
	protected Time heureDepart;
	protected Time heureArrivee;
	protected int nbrSiegesReservesperSection;
	protected int prixSiegeperSection;

	/**
	 * 
	 * @param id
	 */
	public void setidTrajet(String id) {
		this.idTrajet = id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setidCompagnie(String id) {
		this.idCompagnie = id;
	}

	/**
	 * 
	 * @param ville
	 */
	public void setvilleDepart(String ville) {
		this.villeDepart = ville;
	}

	/**
	 * 
	 * @param ville
	 */
	public void setvilleArrivee(String ville) {
		this.villeArrivee = ville;
	}

	/**
	 * 
	 * @param date
	 */
	public void setdateDepart(Date date) {
		this.dateDepart = date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setdateArrivee(Date date) {
		this.dateArrivee = date;
	}

	/**
	 * 
	 * @param time
	 */
	public void setheureDepart(Time time) {
		this.heureDepart = time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setheureArrivee(Time time) {
		this.heureArrivee = time;
	}

	/**
	 * 
	 * @param nbSieges
	 */
	public void setnbrSiegesReservesperSection(int nbSieges) {
		this.nbrSiegesReservesperSection = nbSieges;
	}

	/**
	 * 
	 * @param prix
	 */
	public void setprixSiegeperSection(int prix) {
		this.prixSiegeperSection = prix;
	}

	public String getidTrajet() {
		return this.idTrajet;
	}

	public String getidCompagnie() {
		return this.idCompagnie;
	}

	public String getvilleDepart() {
		return this.villeDepart;
	}

	public String getvilleArrivee() {
		return this.villeArrivee;
	}

	public Time getHeureDepart() {
		return this.heureDepart;
	}

	public Time getHeureArrivee() {
		return this.heureArrivee;
	}

	public int getnbrSiegesReservesperSection() {
		return this.nbrSiegesReservesperSection;
	}

	public double getprixSiegeperSection() {
		// TODO - implement DonneesVoyage.getprixSiegeperSection
		throw new UnsupportedOperationException();
	}

}