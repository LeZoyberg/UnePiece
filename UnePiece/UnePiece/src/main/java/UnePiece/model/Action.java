package UnePiece.model;

public class Action {

	private Integer id;
	private boolean choix;
	private int degatNavire;
	private int degatMembre;
	private int tresors;
	private Event event;
	
	public Action(Integer id, boolean choix, int degatNavire, int degatMembre, int tresors, Event event) {
		this.id = id;
		this.choix = choix;
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresors = tresors;
		this.event = event;
	}
	public Action(boolean choix, int degatNavire, int degatMembre, int tresors, Event event) {
		this.choix = choix;
		this.degatNavire = degatNavire;
		this.degatMembre = degatMembre;
		this.tresors = tresors;
		this.event = event;
	}
	public Action() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isChoix() {
		return choix;
	}
	public void setChoix(boolean choix) {
		this.choix = choix;
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
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
