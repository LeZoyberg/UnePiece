package UnePiece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private boolean taverne;
	private boolean auberge;
	private boolean chantier;
	private int attente;
	private int ordre;
	@Enumerated
	private Mer mer;
	private boolean ileFinale;

	public Ile() {
	}

	public Ile(String nom, boolean taverne, boolean auberge, boolean chantier, int attente, int ordre, Mer mer,
			boolean ileFinale) {
		this.nom = nom;
		this.taverne = taverne;
		this.auberge = auberge;
		this.chantier = chantier;
		this.attente = attente;
		this.ordre = ordre;
		this.mer = mer;
		this.ileFinale = ileFinale;
	}

	public Ile(String nom, boolean taverne, boolean auberge, boolean chantier, int attente, int ordre, Mer mer) {
		this.nom = nom;
		this.taverne = taverne;
		this.auberge = auberge;
		this.chantier = chantier;
		this.attente = attente;
		this.ordre = ordre;
		this.mer = mer;
		this.ileFinale = false;
	}

	public Ile(Integer id, String nom, boolean taverne, boolean auberge, boolean chantier, int attente, int ordre,
			Mer mer,
			boolean ileFinale) {
		this.id = id;
		this.nom = nom;
		this.taverne = taverne;
		this.auberge = auberge;
		this.chantier = chantier;
		this.attente = attente;
		this.ordre = ordre;
		this.mer = mer;
		this.ileFinale = ileFinale;
	}

	public boolean isIleFinale() {
		return ileFinale;
	}

	public void setIleFinale(boolean ileFinale) {
		this.ileFinale = ileFinale;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public boolean isTaverne() {
		return taverne;
	}


	public void setTaverne(boolean taverne) {
		this.taverne = taverne;
	}


	public boolean isAuberge() {
		return auberge;
	}


	public void setAuberge(boolean auberge) {
		this.auberge = auberge;
	}


	public boolean isChantier() {
		return chantier;
	}


	public void setChantier(boolean chantier) {
		this.chantier = chantier;
	}


	public int getAttente() {
		return attente;
	}


	public void setAttente(int attente) {
		this.attente = attente;
	}


	public int getOrdre() {
		return ordre;
	}


	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}


	public Mer getMer() {
		return mer;
	}


	public void setMer(Mer mer) {
		this.mer = mer;
	}
	
	
}
