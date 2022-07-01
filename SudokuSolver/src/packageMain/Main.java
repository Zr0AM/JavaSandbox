package packageMain;

public class Main {

	private static Board board;

	public static void main(String[] args) {

		int[][] tempBoard = { { 0, 0, 4, 0, 2, 0, 1, 0, 6 }, { 0, 0, 0, 0, 0, 0, 0, 8, 0 },
				{ 5, 0, 0, 0, 0, 7, 0, 0, 0 }, { 0, 6, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 6, 0, 3, 0, 4 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 9 }, { 4, 0, 0, 5, 0, 0, 8, 0, 3 }, { 0, 0, 0, 0, 3, 0, 0, 9, 0 },
				{ 0, 0, 8, 0, 0, 0, 0, 2, 0 }, };

		board = new Board();

		board.setBoard(tempBoard);

		/**
		 * board.setElement(1, 3, 4); board.setElement(1, 5, 2); board.setElement(1, 7,
		 * 1); board.setElement(1, 9, 6); board.setElement(2, 8, 8); board.setElement(3,
		 * 1, 5); board.setElement(3, 6, 7); board.setElement(4, 2, 6);
		 * board.setElement(4, 4, 2); board.setElement(5, 3, 1); board.setElement(5, 5,
		 * 6); board.setElement(5, 7, 3); board.setElement(5, 9, 4); board.setElement(6,
		 * 9, 9); board.setElement(7, 1, 4); board.setElement(7, 4, 5);
		 * board.setElement(7, 7, 8); board.setElement(7, 9, 3); board.setElement(8, 5,
		 * 3); board.setElement(8, 8, 9); board.setElement(9, 3, 8); board.setElement(9,
		 * 8, 2);
		 */

		System.out.println("Game started");

		board.printBoard();

		if (board.solveBoard()) {

			System.out.println("Board solved: " + board.boardSolved());

			board.printBoard();

		} else {
			
			System.out.println("Board not solved");

		}

	}

}
