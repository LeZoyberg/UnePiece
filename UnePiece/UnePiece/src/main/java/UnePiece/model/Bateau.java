package UnePiece.model;

public class Bateau {

	private Integer id;
	private String nom;
	private int capacite;
	private int robustesse;
	private int prix;
	private boolean debut;
	
	public Bateau(Integer id, String nom, int capacite, int robustesse, int prix, boolean debut) {
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.robustesse = robustesse;
		this.prix = prix;
		this.debut = debut;
	}
	public Bateau(String nom, int capacite, int robustesse, int prix, boolean debut) {
		this.nom = nom;
		this.capacite = capacite;
		this.robustesse = robustesse;
		this.prix = prix;
		this.debut = debut;
	}
	public Bateau() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getRobustesse() {
		return robustesse;
	}
	public void setRobustesse(int robustesse) {
		this.robustesse = robustesse;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public boolean isDebut() {
		return debut;
	}
	public void setDebut(boolean debut) {
		this.debut = debut;
	}
	
	
}
