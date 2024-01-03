package UnePiece.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private int tresor;
	private int duree;
	@OneToMany(mappedBy = "partie")
	private List<Membre> membres = new ArrayList();
	@ManyToOne
	@JoinColumn(name = "id_ile")
	private Ile ile;
	@OneToOne
	@JoinColumn(name = "id_navire")
	private Navire navire;
	@ManyToOne
	@JoinColumn(name = "id_joueur")
	private Joueur joueur;
	@OneToMany(mappedBy = "partie")
	private List<Action> actions = new ArrayList();
	private int joursRestants;
	
	public Partie() {}
	
	public Partie(Integer id, LocalDate dateDebut, boolean termine, int tresor, int duree, List<Membre> membres, Ile ile,
			Navire navire, Joueur joueur, List<Action> actions) {
				this.id = id;
		this.dateDebut = dateDebut;
		this.termine = termine;
		this.tresor = tresor;
		this.duree = duree;
		this.membres = membres;
		this.ile = ile;
		this.navire = navire;
		this.joueur = joueur;
		this.actions = actions;
	}

	public Partie(LocalDate dateDebut, boolean termine, int tresor, int duree, List<Membre> membres, Ile ile,
			Navire navire, Joueur joueur, List<Action> actions) {
		this.dateDebut = dateDebut;
		this.termine = termine;
		this.tresor = tresor;
		this.duree = duree;
		this.membres = membres;
		this.ile = ile;
		this.navire = navire;
		this.joueur = joueur;
		this.actions = actions;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getJoursRestants() {
		return joursRestants;
	}

	public void setJoursRestants(int joursRestants) {
		this.joursRestants = joursRestants;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public boolean isTermine() {
		return termine;
	}
	public void setTermine(boolean termine) {
		this.termine = termine;
	}
	public int getTresor() {
		return tresor;
	}
	public void setTresor(int tresor) {
		this.tresor = tresor;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public List<Membre> getMembres() {
		return membres;
	}
	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}
	public Ile getIle() {
		return ile;
	}
	public void setIle(Ile ile) {
		this.ile = ile;
	}
	public Navire getNavire() {
		return navire;
	}
	public void setNavire(Navire navire) {
		this.navire = navire;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", dateDebut=" + dateDebut + ", termine=" + termine + ", tresor=" + tresor
				+ ", duree=" + duree + ", ile=" + ile + ", navire=" + navire + "]";
	}
	
}
