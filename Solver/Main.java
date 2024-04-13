package Solver;

public class Main {

	private static int[] array = { 1, 2, 3, 4, 5, 2, 4, 6, 5, 8, 5, 1, 1, 6, 8, 5, 1, 5, 9, 8, 9, 6, 6, 4, 8, 6 };

	private static int max;

	private static int goal = 222;

	private static int sum;

	public static void main(String[] args) {

		max = (int) Math.pow(2, array.length);

		String temp;

		System.out.println("Goal: " + goal);
		System.out.println("Length: " + max);

		for (int i = 1; i < max; i++) {

			temp = String.format("%" + array.length + "s", Integer.toBinaryString(i)).replaceAll(" ", "0");

			// System.out.println("Index: " + i + ", " + temp);

			solve(temp, i);

		}

	}

	private static void solve(String string, int index) {

		sum = 0;
		String elements;
		elements = "[";

		for (int i = 0; i < string.length(); i++) {

			if (string.substring(i, i + 1).compareTo("1") == 0) {

				sum += array[i];
				elements += array[i] + ",";

			}

		}

		// elements = string.substring(0, elements.length()-1) + "]";

		if (sum == goal) {

			elements = elements.substring(0, elements.length() - 1) + "]";

			// System.out.println("Index: " + index + " | " + string + " | " + elements);
			System.out.println(elements);

		} else {

			// System.out.println("No match");

		}

	}

}

