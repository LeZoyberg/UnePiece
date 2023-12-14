package UnePiece.model;

public enum Mer {

	Eastblue(1),Westblue(2),NorthBlue(3),SouthBlue(4),GrandLine(5),NewWorld(7);

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
