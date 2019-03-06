import java.awt.*;
import javax.swing.*;

public class ChessBoard {
	protected static JButton[] buttons;
	protected static ChessPiece[][] gameBoard;
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		buttons = new JButton[64];
		gameBoard = new ChessPiece[8][8];
		
		Pawn pawnb1 = new Pawn(0, 1, false);
		gameBoard[0][1] = pawnb1;
		Pawn pawnb2 = new Pawn(1, 1, false);
		gameBoard[1][1] = pawnb2;
		Pawn pawnb3 = new Pawn(2, 1, false);
		gameBoard[2][1] = pawnb3;
		Pawn pawnb4 = new Pawn(3, 1, false);
		gameBoard[3][1] = pawnb4;
		Pawn pawnb5 = new Pawn(4, 1, false);
		gameBoard[4][1] = pawnb5;
		Pawn pawnb6 = new Pawn(5, 1, false);
		gameBoard[5][1] = pawnb6;
		Pawn pawnb7 = new Pawn(6, 1, false);
		gameBoard[6][1] = pawnb7;
		Pawn pawnb8 = new Pawn(7, 1, false);
		gameBoard[7][1] = pawnb8;

		Rook rookb1 = new Rook(0, 0, false);
		gameBoard[0][0] = rookb1;
		Rook rookb2 = new Rook(7, 0, false);
		gameBoard[7][0] = rookb2;

		Knight knightb1 = new Knight(1, 0, false);
		gameBoard[1][0] = knightb1;
		Knight knightb2 = new Knight(6, 0, false);
		gameBoard[6][0] = knightb2;

		Bishop bishopb1 = new Bishop(2, 0, false);
		gameBoard[2][0] = bishopb1;
		Bishop bishopb2 = new Bishop(5, 0, false);
		gameBoard[5][0] = bishopb2;

		Queen queenb1 = new Queen(3, 0, false);
		gameBoard[3][0] = queenb1;

		King kingb1 = new King(4, 0, false);
		gameBoard[4][0] = kingb1;
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (gameBoard[x][y] == null) {
					gameBoard[x][y] = new Blank(x, y, false);
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(gameBoard[j][i] + " ");
			}
			System.out.println();
		}

		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(8, 8));
		for (int i = 0; i < 64; i++) {
			buttons[i] = new JButton();
			buttons[i].setName(i % 8 + ", " + i / 8);
			buttons[i].setText(gameBoard[i % 8][i / 8].getImage());
			buttons[i].setFont(new Font("TimesRoman", Font.PLAIN, 36));
			buttons[i].setBackground(((i % 8 % 2 == 0) ? ((i / 8 % 2 == 0) ? Color.WHITE : Color.LIGHT_GRAY) 
						: ((i / 8 % 2 == 0) ? Color.LIGHT_GRAY : Color.WHITE)));
			buttons[i].addMouseListener(new ColorChanger());
			buttons[i].addActionListener(new TileListener());
			jp.add(buttons[i]);	
		}
		jf.add(jp);
		jf.setTitle("Chess");
		jf.setSize(600, 600);
		jf.setVisible(true);
	}
	
	public static ChessPiece getPiece(int x, int y) {
		return gameBoard[x][y];
	}
	
	public static void updateGuiContents(ChessPiece piece, int newX, int newY) {
		buttons[piece.getY() * 8 + piece.getX()].setText("");
		buttons[newY * 8 + newX].setText(piece.getImage());
	}
}
