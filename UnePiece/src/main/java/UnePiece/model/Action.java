package UnePiece.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean choix;
	@Column(name="degat_navire")
	private int degatNavire;
	@Column(name="degat_membre")
	private int degatMembre;
	private int tresors;
	@Embedded
	private Evenement event;
	@ManyToOne
	private Partie partie;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isChoix() {
		return choix;
	}
	public void setChoix(boolean choix) {
		this.choix = choix;
	}
	public int getDegatNavire() {
		return degatNavire;
	}
	public void setDegatNavire(int degatNavire) {
		this.degatNavire = degatNavire;
	}
	public int getDegatMembre() {
		return degatMembre;
	}
	public void setDegatMembre(int degatMembre) {
		this.degatMembre = degatMembre;
	}
	public int getTresors() {
		return tresors;
	}
	public void setTresors(int tresors) {
		this.tresors = tresors;
	}
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
