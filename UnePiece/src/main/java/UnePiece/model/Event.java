package UnePiece.model;

public class Event {

	private Integer id;
	private int degatNavire;
	private int degatMembre;
	private int tresors;
	private Odyssee odyssee;
	
	public Event(Integer id, int degatNavire, int degatMembre, int tresors, Odyssee odyssee) {
		this.id = id;
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresors = tresors;
		this.odyssee = odyssee;
	}
	public Event(int degatNavire, int degatMembre, int tresors, Odyssee odyssee) {
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresors = tresors;
		this.odyssee = odyssee;
	}
	public Event() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getTresors() {
		return tresors;
	}
	public void setTresors(int tresors) {
		this.tresors = tresors;
	}
	public Odyssee getOdyssee() {
		return odyssee;
	}
	public void setOdyssee(Odyssee odyssee) {
		this.odyssee = odyssee;
	}
	
}
