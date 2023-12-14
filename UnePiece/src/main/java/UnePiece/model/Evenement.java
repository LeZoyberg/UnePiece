package UnePiece.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="degat_navire")
	private int degatNavire;
	@Column(name="degat_membre")
	private int degatMembre;
	private int tresors;
	@Enumerated(EnumType.STRING)
	private Odyssee odyssee;
	
	public Evenement() {}
	
	public Integer getId() {
		return id;
	}
	public int getDegatNavire() {
		return degatNavire;
	}
	public int getDegatMembre() {
		return degatMembre;
	}
	public int getTresors() {
		return tresors;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDegatNavire(int degatNavire) {
		this.degatNavire = degatNavire;
	}
	public void setDegatMembre(int degatMembre) {
		this.degatMembre = degatMembre;
	}
	public void setTresors(int tresors) {
		this.tresors = tresors;
	}
	public Odyssee getOdyssee() {
		return odyssee;
	}
	public void setOdyssee(Odyssee odyssee) {
		this.odyssee = odyssee;
	}
	
	
}