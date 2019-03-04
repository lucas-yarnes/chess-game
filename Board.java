package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import gamePieces.*;

public class Board {
	
	private static ChessPiece[][] gameBoard;
	private static int selectedX;
	private static int selectedY;
	private static int counter;
	private static JButton[][] buttons;
	private static ChessPiece selectedPiece;
	
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
		//
		//Fill Rest of Spaces with blank objects
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (gameBoard[row][col] == null) {
					gameBoard[row][col] = new Blank();
				}
			}
		}
		//
		//
		//Implementation for creation of a GUI
		buttons = new JButton[8][8];
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(8, 8));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Chess Game");
		jf.setSize(600, 600);
		jf.setLocationRelativeTo(null);
		
		int count = 0;
		Color color = Color.BLUE;
		int row2 = 0;
		int col2 = 0;
		
		for(int row = 0; row < 8; row++) {
			
			for(int col = 0; col < 8; col++, count++) {
				
				buttons[row][col] = new JButton();
				buttons[row][col].setName(row + ", " + col);
				if (row % 2 == 0) {
					color = (col % 2 == 0) ? Color.white : Color.LIGHT_GRAY;
				}
				else {
					color = (count % 2 == 0) ? Color.LIGHT_GRAY : Color.white;
				}
				buttons[row][col].setBackground(color);
				buttons[row][col].addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	((JButton)evt.getSource()).setBackground(Color.BLUE);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	if (Integer.parseInt(((JButton)evt.getSource()).getName().substring(3, 4)) % 2 == 0) {
				    		if(Integer.parseInt(((JButton)evt.getSource()).getName().substring(0, 1)) % 2 == 0) {
				    			((JButton)evt.getSource()).setBackground(Color.WHITE);
				    		}
				    		else {
				    			((JButton)evt.getSource()).setBackground(Color.LIGHT_GRAY);
				    		}
				    	}
				    	else {
				    		if(Integer.parseInt(((JButton)evt.getSource()).getName().substring(0, 1)) % 2 == 0) {
				    			((JButton)evt.getSource()).setBackground(Color.LIGHT_GRAY);
				    		}
				    		else {
				    			((JButton)evt.getSource()).setBackground(Color.WHITE);
				    		}
				    	}
				    }
				});
				if(this.getPiece(col, row) != null) {
					buttons[row][col].setIcon(this.getPiece(col, row).getIcon());
				}
				buttons[row][col].addActionListener(new TileListener());
				jp.add(buttons[row][col]);
				col2++;
			}
			row2++;
			
		}
		jf.add(jp);		
		jf.setVisible(true);
		
	}
	
	public ChessPiece[][] getGameBoard() {
		return this.gameBoard;
	}
	
	public static void changePosition(ChessPiece piece, int newX, int newY) {
		int oldX = piece.getXPos();
		int oldY = piece.getYPos();
		if (piece.isValidMove(newX, newY) && gameBoard[newX][newY].toString().equals("Blank")) {
			boolean check = true;
			switch (piece.toString()) {
			case "Rook":
				if (oldX != newX) {
					for (int start = 0; start < newX - oldX; start++) {
						if (!gameBoard[start][newY].toString().equals("Blank")) {
							check = false;
						}
					}
				}
				else {
					for (int start = 0; start < newY - oldY; start++) {
						if (!gameBoard[newX][start].toString().equals("Blank")) {
							check = false;
						}
					}					
				}
			}
			if (check) {
				piece.movePiece(newX,  newY);
				gameBoard[piece.getXPos()][piece.getYPos()] = piece;
				gameBoard[oldX][oldY] = new Blank();
			}

		}
		
	}
	
	public static ChessPiece getPiece(int x, int y) {
		return gameBoard[x][y];
	}
	
	public boolean canAttack(ChessPiece piece) {
		return false;
	}
	
	public static void updateGuiContents() {
		for (int row = 0; row < 8; row++) {
			for (int col= 0; col < 8; col++) {
				if(gameBoard[col][row] != null) {
					buttons[row][col].setIcon(gameBoard[col][row].getIcon());
				}
				else {
					buttons[row][col].setIcon(null);
				}
			}
		}
	}
	
	public static void setSelectedPos(int selX, int selY, int count) {
		try {
			selectedX = selX;
			selectedY = selY;
			counter = count;
			if (counter == 1) {
				selectedPiece = gameBoard[selectedX][selectedY];
				System.out.println("Selected: " + selectedPiece);
			}
			if (counter == 2) {
				changePosition(selectedPiece, selectedX, selectedY);
			}
			updateGuiContents();
		} catch (NullPointerException e) {
			System.err.println(e);
		}
	}
	
}
