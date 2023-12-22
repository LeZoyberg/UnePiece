package UnePiece.controller.dto;

import java.time.LocalDate;

public class PartieResponse {
	
	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private Integer tresor;
	private Integer duree;
	private Integer ileId;
	private Integer navireId;
	private Integer joueurId;
	
	public Integer getId() {
		return id;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public boolean isTermine() {
		return termine;
	}
	public Integer getTresor() {
		return tresor;
	}
	public Integer getDuree() {
		return duree;
	}
	public Integer getIleId() {
		return ileId;
	}
	public Integer getNavireId() {
		return navireId;
	}
	public Integer getJoueurId() {
		return joueurId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public void setTermine(boolean termine) {
		this.termine = termine;
	}
	public void setTresor(Integer tresor) {
		this.tresor = tresor;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public void setIleId(Integer ileId) {
		this.ileId = ileId;
	}
	public void setNavireId(Integer navireId) {
		this.navireId = navireId;
	}
	public void setJoueurId(Integer joueurId) {
		this.joueurId = joueurId;
	}
	
	
	
}
