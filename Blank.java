public class Blank extends ChessPiece {
	public Blank(int x, int y, boolean isWhite) {
		super(x, y);
		wImg = "";
		bImg = "";
	}

	public boolean checkForLegality(int newX, int newY, ChessPiece piece) {
		return false;
	}
	
	public boolean checkForSkipping(int newX, int newY, ChessPiece[][] gameBoard) {
		return false;
	}
	
	public String toString() {
		return "Blank";
	}
	
}
