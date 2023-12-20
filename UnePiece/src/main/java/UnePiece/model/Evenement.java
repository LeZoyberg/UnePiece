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
	private int tresor;
	@Enumerated(EnumType.STRING)
	private Odyssee odyssee;
	
	public Evenement() {}
	
	public Evenement(int degatNavire, int degatMembre, int tresor, Odyssee odyssee) {
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresor = tresor;
		this.odyssee = odyssee;
	}

	public Integer getId() {
		return id;
	}
	public int getDegatNavire() {
		return degatNavire;
	}
	public int getDegatMembre() {
		return degatMembre;
	}
	public int getTresor() {
		return tresor;
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
	public void setTresor(int tresor) {
		this.tresor = tresor;
	}
	public Odyssee getOdyssee() {
		return odyssee;
	}
	public void setOdyssee(Odyssee odyssee) {
		this.odyssee = odyssee;
	}
	
	
}