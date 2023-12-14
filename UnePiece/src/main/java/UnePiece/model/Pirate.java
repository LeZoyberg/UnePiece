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
	private int force;
	private int pv;
	private int prime;
	private boolean fruit;
	private boolean capitaine;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
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
}
