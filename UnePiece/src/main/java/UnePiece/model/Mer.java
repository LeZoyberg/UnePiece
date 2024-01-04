package UnePiece.model;

import com.fasterxml.jackson.annotation.JsonFormat;


public enum Mer {

	
	EastBlue(1),WestBlue(2),NorthBlue(3),SouthBlue(4),GrandLine(5),NewWorld(7);

	private int dangerosite;

	Mer(int dangerosite) {
		this.setDangerosite(dangerosite);
	}

	public int getDangerosite() {
		return dangerosite;
	}

	public void setDangerosite(int dangerosite) {
		this.dangerosite = dangerosite;
	}

}
