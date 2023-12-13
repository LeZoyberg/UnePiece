package UnePiece.model;

public class Pirate {

	private int id;
	private int force;
	private int pv;
	private int prime;
	private boolean fruitdemon;
	private boolean capitaine;
	
	public Pirate() {}
	
	public Pirate(int id, int force, int pv, int prime, boolean fruitdemon, boolean capitaine) {
		this.id = id;
		this.force = force;
		this.pv = pv;
		this.prime = prime;
		this.fruitdemon = fruitdemon;
		this.capitaine = capitaine;
	}
	public Pirate(int force, int pv, int prime, boolean fruitdemon, boolean capitaine) {
		this.force = force;
		this.pv = pv;
		this.prime = prime;
		this.fruitdemon = fruitdemon;
		this.capitaine = capitaine;
	}

	public int getId() {
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

	public boolean isFruitdemon() {
		return fruitdemon;
	}

	public void setFruitdemon(boolean fruitdemon) {
		this.fruitdemon = fruitdemon;
	}

	public boolean isCapitaine() {
		return capitaine;
	}

	public void setCapitaine(boolean capitaine) {
		this.capitaine = capitaine;
	}
}
