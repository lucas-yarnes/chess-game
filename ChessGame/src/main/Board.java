package main;

import gamePieces.*;

public class Board {
	
	private ChessPiece[][] gameBoard;
	
	public Board() {
		
		//Create Game Pieces for the Black Team
		//
		//Pawns
		gameBoard = new ChessPiece[8][8];
		
		Pawn pawnb1 = new Pawn(0, 1, "Black");
		gameBoard[pawnb1.getXPos()][pawnb1.getYPos()] = pawnb1;
		Pawn pawnb2 = new Pawn(1, 1, "Black");
		gameBoard[pawnb2.getXPos()][pawnb2.getYPos()] = pawnb2;
		Pawn pawnb3 = new Pawn(2, 1, "Black");
		gameBoard[pawnb3.getXPos()][pawnb3.getYPos()] = pawnb3;
		Pawn pawnb4 = new Pawn(3, 1, "Black");
		gameBoard[pawnb4.getXPos()][pawnb4.getYPos()] = pawnb4;
		Pawn pawnb5 = new Pawn(4, 1, "Black");
		gameBoard[pawnb5.getXPos()][pawnb5.getYPos()] = pawnb5;
		Pawn pawnb6 = new Pawn(5, 1, "Black");
		gameBoard[pawnb6.getXPos()][pawnb6.getYPos()] = pawnb6;
		Pawn pawnb7 = new Pawn(6, 1, "Black");
		gameBoard[pawnb7.getXPos()][pawnb7.getYPos()] = pawnb7;
		Pawn pawnb8 = new Pawn(7, 1, "Black");
		gameBoard[pawnb8.getXPos()][pawnb8.getYPos()] = pawnb8;
		//Pawns
		//
		//Rooks
		Rook rookb1 = new Rook(0, 0, "Black");
		gameBoard[rookb1.getXPos()][rookb1.getYPos()] = rookb1;
		Rook rookb2 = new Rook(7, 0, "Black");
		gameBoard[rookb2.getXPos()][rookb2.getYPos()] = rookb2;
		//Rooks
		//
		//Knights
		Knight knightb1 = new Knight(1, 0, "Black");
		gameBoard[knightb1.getXPos()][knightb1.getYPos()] = knightb1;
		Knight knightb2 = new Knight(6, 0, "Black");
		gameBoard[knightb2.getXPos()][knightb2.getYPos()] = knightb2;
		//Knights
		//
		//Bishops
		Bishop bishopb1 = new Bishop(2, 0, "Black");
		gameBoard[bishopb1.getXPos()][bishopb1.getYPos()] = bishopb1;
		Bishop bishopb2 = new Bishop(5, 0, "Black");
		gameBoard[bishopb2.getXPos()][bishopb2.getYPos()] = bishopb2;
		//Bishops
		//
		//Queen
		Queen queenb1 = new Queen(3, 0, "Black");
		gameBoard[queenb1.getXPos()][queenb1.getYPos()] = queenb1;
		//Queen
		//
		//King
		King kingb1 = new King(4, 0, "Black");
		gameBoard[kingb1.getXPos()][kingb1.getYPos()] = kingb1;
		//King
		
	}
	
	public ChessPiece[][] getGameBoard() {
		return this.gameBoard;
	}
	
	public void changePosition(ChessPiece piece, int newX, int newY) {
		gameBoard[piece.getXPos()][piece.getYPos()] = null;
		piece.movePiece(newX,  newY);
		gameBoard[piece.getXPos()][piece.getYPos()] = piece;
	}
	
	public ChessPiece getPiece(int x, int y) {
		return gameBoard[x][y];
	}

}
