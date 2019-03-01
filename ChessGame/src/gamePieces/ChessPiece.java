package gamePieces;

import javax.swing.ImageIcon;

public abstract class ChessPiece {
	
	int xPos;
	int yPos;
	String teamColor;
	ImageIcon img;
	
	public abstract void movePiece(int xPos, int yPos);
	public abstract boolean isValidMove(int xDest, int yDest);
	public abstract String toString();
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}

}
