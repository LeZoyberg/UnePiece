package UnePiece.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean choix;
	private boolean termine;
	@Column(name="degat_navire")
	private int degatNavire;
	@Column(name="degat_membre")
	private int degatMembre;
	private int tresor;
	@ManyToOne
	@JoinColumn(name = "id_event")
	private Evenement event;
	@ManyToOne
	@JoinColumn(name="partie")
	private Partie partie;
	
	public Action() {}
	
	public Action(int degatNavire, int degatMembre, int tresor, Evenement event) {
		this.choix = null;
		this.termine = false;
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresor = tresor;
		this.event = event;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean isChoix() {
		return choix;
	}
	public void setChoix(Boolean choix) {
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
	public int getTresor() {
		return tresor;
	}
	public void setTresor(int tresor) {
		this.tresor = tresor;
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
	public boolean isTermine() {
		return termine;
	}
	public void setTermine(boolean termine) {
		this.termine = termine;
	}
	
	
}
