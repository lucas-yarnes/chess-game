package gamePieces;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.Board;

public class Pawn extends ChessPiece {
	
	private boolean hasMoved;

	//purely testing purposes
	public Pawn() {}
	
	//create a pawn with a starting (x, y) position
	public Pawn(int startX, int startY, String teamColor) {
		xPos = startX;
		yPos = startY;
		this.teamColor = teamColor;
		hasMoved = false;
		try {
			img = new ImageIcon(ImageIO.read(getClass().getResource("resources/water.bmp")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//move the pawn to a given (x, y) position IF AND ONLY IF the selected move is valid
	@Override
	public void movePiece(int xDest, int yDest) {
		if (isValidMove(xDest, yDest)) {
			this.xPos = xDest;
			this.yPos = yDest;
			hasMoved = true;
			System.out.println("Piece Moved");
		}
		else {
			System.out.println("Not a valid move");
		}
		
	}
	
	//This method checks to see if this piece can perform the requested move given the rules of chess
	@Override
	public boolean isValidMove(int xDest, int yDest) {
		boolean check = false;
		if (hasMoved) {
			check = (yDest == yPos + 1);
		}
		else {
			check = (yDest == yPos + 1 || yDest == yPos + 2);
		}
		
		return check;
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}

}
