public class Bishop extends ChessPiece {
	
	public Bishop(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
		bImg = "\u265d";
	    wImg = "\u2657";
	}
	
	public boolean checkForLegality(int x, int y, ChessPiece piece) {
		if(piece.toString().equals("Blank") || (piece.isWhite != this.isWhite)) {
			if (Math.abs(x - xPos) == Math.abs(y - yPos)) {
				return true;
			}
			else 
				return false;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForSkipping(int newX, int newY, ChessPiece[][] gameBoard) {
		int dirX = newX > xPos ? 1 : -1;
		int dirY = newY > yPos ? 1 : -1;
		for (int i = 1; i < Math.abs(newX - xPos); i++) {
			if (ChessBoard.isPieceNotBlank(xPos + i * dirX, yPos + i * dirY)) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return "Bishop";
	}
	
}
