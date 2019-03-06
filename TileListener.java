import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TileListener extends ChessBoard implements ActionListener {
	private static int count;
	private static int origX, origY, newX, newY;
	
	public void actionPerformed(ActionEvent e) {
		count++;
		JButton temp = (JButton)e.getSource();
		if (count % 2 == 1) {
			if (!temp.getText().equals("")) {
				origX = Integer.parseInt(temp.getName().substring(0, 1));
				origY = Integer.parseInt(temp.getName().substring(3, 4));
				//System.out.println(gameBoard[origX][origY]);
			}
		}
		if (count % 2 == 0) {
			newX = Integer.parseInt(temp.getName().substring(0, 1));
			newY = Integer.parseInt(temp.getName().substring(3, 4));
			ChessPiece piece = getPiece(origX, origY);
			//System.out.println(gameBoard[newX][newY]);
			if (piece.checkForLegality(newX, newY, getPiece(newX, newY))) {
				//if (!piece.toString().equals("Rook")) {//|| checkForSkipping(piece, newX, newY)) {
					updateGuiContents(piece, newX, newY);
					gameBoard[origX][origY].setPos(newX, newY);
					gameBoard[newX][newY] = gameBoard[origX][origY];
					gameBoard[origX][origY] = new Blank(origX, origY, false);
				//}
			}
		}
    }
}