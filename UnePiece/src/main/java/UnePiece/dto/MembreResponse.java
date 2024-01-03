package UnePiece.dto;

import UnePiece.model.Pirate;

public class MembreResponse {
	
	private Integer id;
	private int pv;
	private int power;
	private Pirate pirate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pirate getPirate() {
		return pirate;
	}

	public void setPirate(Pirate pirate) {
		this.pirate = pirate;
	}

	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	
}
