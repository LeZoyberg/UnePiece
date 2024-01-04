package UnePiece.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import UnePiece.model.Ile;
import UnePiece.model.Joueur;
import UnePiece.model.Navire;

public class PartieResponse {

	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private Integer tresor;
	private Integer duree;
	private List<MembreResponse> membres = new ArrayList();
	private Navire navire;
	private Ile ile;
	private int dangerosite;
	private int joursRestants;
	private Joueur joueur;
	private Set<ActionResponse> actions = new HashSet();
	
	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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

	public Integer getTresor() {
		return tresor;
	}

	public void setTresor(Integer tresor) {
		this.tresor = tresor;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public List<MembreResponse> getMembres() {
		return membres;
	}

	public void setMembres(List<MembreResponse> membres) {
		this.membres = membres;
	}

	public Navire getNavire() {
		return navire;
	}

	public void setNavire(Navire navire) {
		this.navire = navire;
	}

	public Ile getIle() {
		return ile;
	}

	public void setIle(Ile ile) {
		this.ile = ile;
	}

	public Set<ActionResponse> getActions() {
		return actions;
	}

	public void setActions(Set<ActionResponse> actions) {
		this.actions = actions;
	}

	public int getDangerosite() {
		return dangerosite;
	}

	public void setDangerosite(int dangerosite) {
		this.dangerosite = dangerosite;
	}
	
	

}
