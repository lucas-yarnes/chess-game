package gamePieces;

public class Rook extends ChessPiece {
	
	 //purely testing purposes
	public Rook() {}
	
	//create a rook with a starting (x, y) position
	public Rook(int startX, int startY, String teamColor) {
		xPos = startX;
		yPos = startY;
		this.teamColor = teamColor;
	}

	@Override
	public void movePiece(int xPos, int yPos) {

	}

	@Override
	public boolean isValidMove(int xDest, int yDest) {
		return false;
	}

	@Override
	public String toString() {
		return "Rook";
	}

}
