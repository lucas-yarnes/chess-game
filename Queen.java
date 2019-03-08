public class Queen extends ChessPiece{
	public Queen(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
		bImg = "\u265b";
		wImg = "\u2655";
	}
	
	public boolean checkForLegality(int x, int y, ChessPiece piece) {
		if(piece.toString().equals("Blank") || (piece.isWhite != this.isWhite)) {
			if ((Math.abs(x - xPos) == 0) && (Math.abs(y - yPos) > 0))
				return true;
			else if ((Math.abs(y - yPos) == 0) && (Math.abs(x - xPos) > 0))
				return true;
			else if (Math.abs(x - xPos) == Math.abs(y - yPos))
				return true;
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
		
		if (xPos != newX && yPos != newY) {
			for (int i = 1; i < Math.abs(newX - xPos); i++) {
				if (ChessBoard.isPieceNotBlank(xPos + i * dirX, yPos + i * dirY)) {
					return false;
				}
			}
			return true;
		}
		else {
			if (xPos == newX) {
				for (int i = 1; i < Math.abs(newY - yPos); i++) {
					if (ChessBoard.isPieceNotBlank(newX, yPos + i * dirY)) {
						return false;
					}
				}
				return true;
			}
			else {
				for (int i = 1; i < Math.abs(newX - xPos); i++) {
					if (ChessBoard.isPieceNotBlank(xPos + i * dirX, newY)) {
						return false;
					}
				}
				return true;
			}
		}
	}
	
	public String toString() {
		return "Queen";
	}
}
