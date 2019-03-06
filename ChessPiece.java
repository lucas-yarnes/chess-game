public abstract class ChessPiece {
	protected int xPos;
	protected int yPos;
	protected boolean isWhite;
	protected String wImg;
	protected String bImg;
	
	public ChessPiece(int x, int y, boolean isWhite) {
		this.xPos = x;
		this.yPos = y;
		this.isWhite = isWhite;
	}
	
	public ChessPiece(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	abstract boolean checkForLegality(int x, int y, ChessPiece piece);
		
	public String getImage() {
		if(isWhite) 
			return wImg;
		else 
			return bImg;
	}
	
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
}
