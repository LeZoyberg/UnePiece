package UnePiece.dto;

import java.time.LocalDate;

public class PartieResponse {
	
	private Integer id;
	private LocalDate dateDebut;
	private boolean termine;
	private Integer tresor;
	private Integer duree;

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

	
	
	
}
