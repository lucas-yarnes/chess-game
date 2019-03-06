public class Knight extends ChessPiece {

	public Knight(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
		bImg = "\u265e";
	    wImg = "\u2658";
	}

	public boolean checkForLegality(int x, int y, ChessPiece piece) {
		if(piece.toString().equals("Blank") || (piece.isWhite != this.isWhite)) {
			if ((Math.abs(x - xPos) == 1) && (Math.abs(y - yPos) == 2)) {
				return true;
			}
			else if ((Math.abs(x - xPos) == 2) && (Math.abs(y - yPos) == 1)) {
				return true;
			}
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Knight";
	}

}
