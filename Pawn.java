public class Pawn extends ChessPiece{

	public Pawn(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
		this.bImg = "\u265f";
	    this.wImg = "\u2659";
	}
	
	public boolean checkForLegality(int x, int y, ChessPiece piece) {
		if(piece.toString().equals("Blank") || (piece.isWhite != this.isWhite)) {
			if ((isWhite && y < yPos) || (!isWhite && y > yPos)) {
				if ((x - xPos == 0) && (Math.abs(y - yPos) == 1)) {
					if (piece.toString().equals("Blank"))
						return true;
					else
						return false;
				}
				else if (Math.abs(x - xPos) == 1 && Math.abs(y - yPos) == 1) {
					if (!piece.toString().equals("Blank"))
						return true;
					else
						return false;
				}
				else if ((x - xPos == 0) && Math.abs(y - yPos) == 2) {
					if (this.yPos == 1 || (this.yPos == 6 && this.isWhite))
						return true;
					else
						return false;
				}
				else {
					return false;
				}
			}
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForSkipping(int newX, int newY, ChessPiece[][] gameBoard) {
		int dirY = newY > yPos ? 1 : -1;

		for (int i = 1; i < Math.abs(newY - yPos); i++) {
			if (ChessBoard.isPieceNotBlank(newX, yPos + i * dirY)) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return "Pawn";
	}
}
