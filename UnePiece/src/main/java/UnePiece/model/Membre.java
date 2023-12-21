package UnePiece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int pv;
	private int power;
	@ManyToOne
	@JoinColumn(name = "id_pirate")
	private Pirate pirate;
	@ManyToOne
	@JoinColumn(name="partie")
	private Partie partie;
	
	public Membre() {}
	
	public Membre(int pv, int power, Pirate pirate) {
		this.pv = pv;
		this.power = power;
		this.pirate = pirate;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Pirate getPirate() {
		return pirate;
	}
	public void setPirate(Pirate pirate) {
		this.pirate = pirate;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
	
}
