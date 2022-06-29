package packageMain;

public class Main {

	private static Board board;

	public static void main(String[] args) {

		board = new Board();

		board.setElement(1, 3, 4);
		board.setElement(1, 5, 2);
		board.setElement(1, 7, 1);
		board.setElement(1, 9, 6);
		board.setElement(2, 8, 8);
		board.setElement(3, 1, 5);
		board.setElement(3, 6, 7);
		board.setElement(4, 2, 6);
		board.setElement(4, 4, 2);
		board.setElement(5, 3, 1);
		board.setElement(5, 5, 6);
		board.setElement(5, 7, 3);
		board.setElement(5, 9, 4);
		board.setElement(6, 9, 9);
		board.setElement(7, 1, 4);
		board.setElement(7, 4, 5);
		board.setElement(7, 7, 8);
		board.setElement(7, 9, 3);
		board.setElement(8, 5, 3);
		board.setElement(8, 8, 9);
		board.setElement(9, 3, 8);
		board.setElement(9, 8, 2);

		board.printBoard();

		while (!board.boardSolved()) {

			playGame();

			if (!board.boardSolved()) {

				System.out.println("reverted");
				board.revertBoardState();
				board.printBoard();
				
				playGame();

			}

		}

		System.out.println("Board solved: " + board.boardSolved());

		board.printBoard();

	}

	public static void playGame() {

		for (int row = 1; row < 10; row++) {

			for (int col = 1; col < 10; col++) {

				for (int value = 1; value < 10; value++) {

					board.setElement(row, col, value);

					if (board.elementSet() && !board.boardSolved()) {
						
						board.printBoard();

						playGame();

					}

				}

			}

		}

	}

}
