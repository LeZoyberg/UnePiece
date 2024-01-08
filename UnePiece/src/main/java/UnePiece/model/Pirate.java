package UnePiece.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pirate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int power;
	private int pv;
	private int prime;
	private boolean fruit;
	private boolean capitaine;
	private String nom;
	private int tier;
	
	public Pirate() {}
	
		public Pirate(int power, int pv, int prime, boolean fruit, boolean capitaine, String nom, int tier) {
		this.power = power;
		this.pv = pv;
		this.prime = prime;
		this.fruit = fruit;
		this.capitaine = capitaine;
		this.nom = nom;
		this.tier = tier;
	}

	public Pirate(int power, int pv, int prime, boolean fruit, boolean capitaine, String nom) {
		this.power = power;
		this.pv = pv;
		this.prime = prime;
		this.fruit = fruit;
		this.capitaine = capitaine;
		this.nom = nom;
		this.tier = 1;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getPrime() {
		return prime;
	}

	public void setPrime(int prime) {
		this.prime = prime;
	}

	public boolean isFruit() {
		return fruit;
	}

	public void setFruit(boolean fruitdemon) {
		this.fruit = fruitdemon;
	}

	public boolean isCapitaine() {
		return capitaine;
	}

	public void setCapitaine(boolean capitaine) {
		this.capitaine = capitaine;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
	
}
