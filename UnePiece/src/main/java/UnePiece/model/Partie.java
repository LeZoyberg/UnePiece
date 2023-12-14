package UnePiece.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private int tresor;
	private int duree;
	@OneToMany
	private List<Membre> membres;
	@Embedded
	private Ile ile;
	@Embedded
	private Navire navire;
	@Embedded
	private Joueur joueur;
	@OneToMany
	private List<Action> actions;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
}
