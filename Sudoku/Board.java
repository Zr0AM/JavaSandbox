package Sudoku;

public class Board {

	private int[][] arrayBoard;

	private final int boardSize = 9;

	public Board() {

		arrayBoard = new int[boardSize][boardSize];

	}

	public void setBoard(int[][] boardIn) {

		for (int row = 0; row < boardSize; row++)
			for (int col = 0; col < boardSize; col++)
				arrayBoard[row][col] = boardIn[row][col];

	}

	public void printBoard() {

		String output = "";

		output += "-------------------------\n";

		for (int i = 0; i < boardSize; i++) {

			output += "| ";

			for (int j = 0; j < boardSize; j++) {

				output += arrayBoard[i][j];

				if ((j + 1) % 3 == 0 && j < boardSize) {

					output += " | ";

				} else {

					output += " ";

				}

			}

			output += "\n";

			if ((i + 1) % 3 == 0 && i < boardSize) {

				output += "-------------------------\n";

			}

		}

		System.out.println(output);

	}

	private boolean textBox(int row, int col, int value) {

		int rowStart = row - row % 3;
		int colStart = col - col % 3;

		for (int rowSearch = rowStart; rowSearch < rowStart + 3; rowSearch++) {
			for (int colSearch = colStart; colSearch < colStart + 3; colSearch++) {

				if (arrayBoard[rowSearch][colSearch] == value) {
					return false;
				}

			}
		}
		return true;

	}

	private boolean testRow(int searchRow, int value) {

		for (int col = 0; col < boardSize; col++) {

			if (arrayBoard[searchRow][col] == value) {

				return false;

			}

		}

		return true;

	}

	private boolean testCol(int searchCol, int value) {

		for (int row = 0; row < boardSize; row++) {

			if (arrayBoard[row][searchCol] == value) {

				return false;

			}

		}

		return true;

	}

	private boolean testValue(int row, int col, int value) {

		if (!testRow(row, value)) {

			return false;

		} else if (!testCol(col, value)) {

			return false;

		} else if (!textBox(row, col, value)) {

			return false;

		}

		return true;

	}

	public boolean boardSolved() {

		for (int row = 0; row < boardSize; row++) {

			for (int col = 0; col < boardSize; col++) {

				if (arrayBoard[row][col] == 0) {

					return false;

				}
			}

		}

		return true;

	}

	public boolean solveBoard() {

		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if (arrayBoard[row][col] == 0) {
					for (int value = 1; value <= boardSize; value++) {
						if (testValue(row, col, value)) {
							arrayBoard[row][col] = value;
							if (this.solveBoard()) {
								return true;
							} else {
								arrayBoard[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
