public class Rook extends ChessPiece{
	public Rook(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
		bImg = "\u265c";
	    wImg = "\u2656";
	}
	
	public boolean checkForLegality(int x, int y, ChessPiece piece) {
		if(piece.toString().equals("Blank") || (piece.isWhite != this.isWhite)) {
			if ((Math.abs(x - xPos) == 0) && (Math.abs(y - yPos) > 0))
				return true;
			else if ((Math.abs(y - yPos) == 0) && (Math.abs(x - xPos) > 0))
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Rook";
	}
}
