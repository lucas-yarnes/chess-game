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
					if (piece.toString().equals("Blank"))
						return true;
					else
						return false;
				}
				else if ((x - xPos == 0) && Math.abs(y - yPos) == 2) {
					if (this.yPos == 1)
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
	
	
	public String toString() {
		return "Pawn";
	}
}
