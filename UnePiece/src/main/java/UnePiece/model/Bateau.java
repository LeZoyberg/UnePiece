package UnePiece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bateau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private int capacite;
	private int robustesse;
	private int prix;
	private boolean debut;
	private int tier;
	
	public Bateau() {}
	
	public Bateau(String nom, int capacite, int robustesse, int prix, boolean debut) {
		this.nom = nom;
		this.capacite = capacite;
		this.robustesse = robustesse;
		this.prix = prix;
		this.debut = debut;
		this.tier = 1;
	}

	public Bateau(String nom, int capacite, int robustesse, int prix, boolean debut, int tier) {
		this.nom = nom;
		this.capacite = capacite;
		this.robustesse = robustesse;
		this.prix = prix;
		this.debut = debut;
		this.tier = tier;
	}
	
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

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getTier() {
		return tier;
	}
	
	
	
}
