package UnePiece.model;

public class Navire {

	private Integer id;
	private int robustesse;
	private Bateau bateau;
	

	public Navire(Integer id, int robustesse, Bateau bateau) {
		this.id = id;
		this.robustesse = robustesse;
		this.bateau=bateau;
	}
	public Navire(int robustesse, Bateau bateau) {
		this.robustesse = robustesse;
		this.bateau=bateau;
	}
	public Navire() {}
	
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
