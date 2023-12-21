package UnePiece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Navire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int robustesse;
	@ManyToOne
	@JoinColumn(name = "id_bateau")
	private Bateau bateau;
	
	public Navire() {}
	
	public Navire(int robustesse, Bateau bateau) {
		this.robustesse = robustesse;
		this.bateau = bateau;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRobustesse() {
		return robustesse;
	}
	public void setRobustesse(int robustesse) {
		this.robustesse = robustesse;
	}
	public Bateau getBateau() {
		return bateau;
	}
	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	
}
