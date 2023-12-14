package UnePiece.model;

import java.time.LocalDate;
import java.util.List;

public class Partie {

	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private int tresor;
	private int duree;
	private List<Membre> membres;
	private Ile ile;
	private Navire navire;
	private Joueur joueur;
	
	public Partie(Integer id, LocalDate dateDebut, boolean termine, int tresor, int duree, List<Membre> membres,
			Ile ile, Navire navire, Joueur joueur) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.termine = termine;
		this.tresor = tresor;
		this.duree = duree;
		this.membres = membres;
		this.ile = ile;
		this.navire = navire;
		this.joueur = joueur;
	}
	public Partie(LocalDate dateDebut, boolean termine, int tresor, int duree, List<Membre> membres,
			Ile ile, Navire navire, Joueur joueur) {
		this.dateDebut = dateDebut;
		this.termine = termine;
		this.tresor = tresor;
		this.duree = duree;
		this.membres = membres;
		this.ile = ile;
		this.navire = navire;
		this.joueur = joueur;
	}
	public Partie() {}
	
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
	
}
