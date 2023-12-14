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

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getForce() {
		return power;
	}

	public void setForce(int power) {
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
}
