package CardWar;

public class Main {

	private static Game game;

	private static long turns;
	private static long wars;
	private static long consecutiveWars;

	public static void main(String[] args) {

		game = new Game();

		turns = 0;
		wars = 0;
		consecutiveWars = 0;

		final long maxCount = 1;

		for (int counter = 0; counter < maxCount; counter++) {

			game.RunGame();

			turns += game.Turns();
			wars += game.Wars();
			consecutiveWars += game.ConsecutiveWars();

		}

		System.out.println("counter: " + maxCount);
		System.out.println("Turns: " + turns);
		System.out.println("wars: " + wars);
		System.out.println("consecutiveWars: " + consecutiveWars);


	}

}
