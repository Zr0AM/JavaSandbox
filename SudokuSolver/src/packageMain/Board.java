package packageMain;

import java.util.Stack;

public class Board {

	private static int[][] arrayBoard;

	private static final int boardSize = 9;

	private static boolean elementSet;

	private static Stack<int[][]> boardStates;
	private static Stack<int[][]> boardHistory;

	public Board() {

		initalizeBoard();

	}

	public static boolean elementSet() {

		return elementSet;

	}

	public void setElement(int row, int col, int value) {

		int localRow = row - 1;
		int localCol = col - 1;

		if (arrayBoard[localRow][localCol] != 0) {

			elementSet = false;
			return;

		} else if (testCol(localCol, value)) {

			elementSet = false;
			return;

		} else if (testRow(localRow, value)) {

			elementSet = false;
			return;

		} else if (testBox(localRow, localCol, value)) {

			elementSet = false;
			return;

		}

		elementSet = true;

		boardStates.add(boardCopy());

		arrayBoard[localRow][localCol] = value;

	}

	private int[][] boardCopy() {

		int[][] boardTemp = new int[boardSize][boardSize];

		for (int row = 0; row < boardSize; row++) {

			for (int col = 0; col < boardSize; col++) {

				boardTemp[row][col] = arrayBoard[row][col];

			}

		}

		return boardTemp;

	}

	private int[][] stateCopy() {

		int[][] boardTemp = new int[boardSize][boardSize];

		int[][] boardState = boardStates.pop();

		for (int row = 0; row < boardSize; row++) {

			for (int col = 0; col < boardSize; col++) {

				boardTemp[row][col] = boardState[row][col];

			}

		}

		return boardTemp;

	}

	public void revertBoardState() {

		boardStates.pop();
		
		arrayBoard = stateCopy();

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

	private static void initalizeBoard() {

		arrayBoard = new int[boardSize][boardSize];

		boardStates = new Stack<int[][]>();
		
		boardHistory = new Stack<int[][]>();

	}

	private static boolean testBox(int searchRow, int searchCol, int value) {

		boolean found = false;

		int lBoundRow = getBound(searchRow, false);
		int uBoundRow = getBound(searchRow, true);

		int lBoundCol = getBound(searchCol, false);
		int uBoundCol = getBound(searchCol, true);

		for (int row = lBoundRow; row < uBoundRow; row++) {

			for (int col = lBoundCol; col < uBoundCol; col++) {

				if (arrayBoard[row][col] == value) {

					found = true;
					break;

				}

			}

		}

		return found;

	}

	private static int getBound(int value, boolean upper) {

		int returnValue = 0;

		if (upper) {

			switch (value) {

			case 0:
			case 1:
			case 2:
				returnValue = 3;
				break;
			case 3:
			case 4:
			case 5:
				returnValue = 6;
				break;
			case 6:
			case 7:
			case 8:
				returnValue = 9;
				break;

			}

		} else {

			switch (value) {

			case 0:
			case 1:
			case 2:
				returnValue = 0;
				break;
			case 3:
			case 4:
			case 5:
				returnValue = 3;
				break;
			case 6:
			case 7:
			case 8:
				returnValue = 6;
				break;

			}

		}

		return returnValue;

	}

	private static boolean testRow(int searchRow, int value) {

		boolean found = false;

		for (int col = 0; col < boardSize; col++) {

			if (arrayBoard[searchRow][col] == value) {

				found = true;
				break;

			}

		}

		return found;

	}

	private static boolean testCol(int searchCol, int value) {

		boolean found = false;

		for (int row = 0; row < boardSize; row++) {

			if (arrayBoard[row][searchCol] == value) {

				found = true;
				break;

			}

		}

		return found;

	}

	public boolean boardSolved() {

		boolean solved = true;

		for (int row = 0; row < boardSize; row++) {

			for (int col = 0; col < boardSize; col++) {

				if (arrayBoard[row][col] == 0) {

					solved = false;
					break;

				}
			}

			if (!solved) {

				break;

			}
		}

		return solved;

	}

}
