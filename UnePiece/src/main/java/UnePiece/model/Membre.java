package UnePiece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int pv;
	private int force;
	private Pirate pirate;
	
	public Membre() {}
	public Membre(int id, int pv, int force, Pirate pirate) {
		this.id = id;
		this.pv = pv;
		this.force = force;
		this.pirate = pirate;
	}
	public Membre(int pv, int force, Pirate pirate) {
		this.pv = pv;
		this.force = force;
		this.pirate = pirate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public Pirate getPirate() {
		return pirate;
	}
	public void setPirate(Pirate pirate) {
		this.pirate = pirate;
	}
	
	
	
}
