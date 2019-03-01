package main;

public class Tester {
	
	public static void main(String[] args) {
		
		Board b = new Board();
	
		b.changePosition(b.getPiece(0, 1), 0, 4);
		//b.changePosition(b.getPiece(0, 3), 0, 4);
		
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(b.getGameBoard()[j][i] + "  ");
			}
			System.out.print('\n');
		}
		
	}

}
