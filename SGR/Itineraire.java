public abstract class Itineraire extends EntiteVoyage implements Visitable {

	protected Date dateDepart;
	protected Time heureDepart;
	protected Time heureArrivee;
	protected Time duree;
	protected Compagnie compagnie;
	protected int numero;
	protected double prix;
	protected int placesDisponibles;
	protected List<Place> places;

}