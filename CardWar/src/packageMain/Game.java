package packageMain;

import java.util.ArrayList;

public class Game {

	private static int turns;
	private static int wars;
	private static int consecutiveWars;

	private static ArrayList<Integer> warList;

	private static Deck deck;
	private static Hand Player1;
	private static Hand Player2;
	private static Hand PlayerPot;

	public void RunGame() {

		Initialize();
		DealCards();

		while (!GameDone()) {

			PlayGame();

		}

		//PrintResults();

	}

	public int Turns() {

		return turns;

	}

	public int Wars() {

		return warList.size();

	}

	public int ConsecutiveWars() {

		return consecutiveWars;

	}

	private static void Initialize() {

		turns = 0;
		wars = 0;
		consecutiveWars = 0;

		deck = new Deck();
		Player1 = new Hand();
		Player2 = new Hand();
		PlayerPot = new Hand();

		warList = new ArrayList<Integer>();

	}

	private static void PrintResults() {

		String output;

		/**
		 * output = "-------------------------------" + '\n'; output += " Results" +
		 * '\n'; output += "-------------------------------" + '\n'; output += "" +
		 * '\n'; output += " Turn count: " + turns + '\n'; output += " War count: " +
		 * warList.size() + '\n'; output += " Consecutive wars: " + consecutiveWars +
		 * '\n'; output += "" + '\n'; output += " War list:" + '\n'; output +=
		 * warList.toString();
		 */

		output = turns + "\t" + warList.size() + "\t" + consecutiveWars + "\t" + warList.toString();

		System.out.println(output);

	}

	private static void DealCards() {

		while (!deck.DeckEmpty()) {

			Player1.AddCard(deck.DealCard());

			if (!deck.DeckEmpty()) {

				Player2.AddCard(deck.DealCard());

			}

		}

	}

	private static void PlayGame() {

		turns++;

		if (Player1.Size() == 0 && Player2.Size() == 0) {

			PlayerPot.ShuffleHand();

			Player1.AddCard(PlayerPot.TopCard());
			Player2.AddCard(PlayerPot.TopCard());

		}

		PlayHand();

	}

	private static void PlayHand() {

		if (Player1.TopCard() > Player2.TopCard()) {

			Player1.AddCard(Player2.RemoveCard());

			if (!PlayerPot.IsEmpty()) {

				AddCardPot(Player1);

			}

		} else if (Player1.TopCard() < Player2.TopCard()) {

			Player2.AddCard(Player1.RemoveCard());

			if (!PlayerPot.IsEmpty()) {

				AddCardPot(Player2);

			}

		} else {

			wars++;

			if (!PlayerPot.IsEmpty()) {

				consecutiveWars++;

			}

			AddToPot(Player1);
			AddToPot(Player2);

		}

	}

	private static void AddToPot(Hand player) {

		for (int counter = 0; counter < 3; counter++) {

			if (player.Size() > 1) {

				PlayerPot.AddCard(player.RemoveCard());

			}

		}

	}

	private static void AddCardPot(Hand player) {

		PlayerPot.ShuffleHand();

		while (!PlayerPot.IsEmpty()) {

			player.AddCard(PlayerPot.RemoveCard());

		}

		warList.add(wars);

		wars = 0;

	}

	private static boolean GameDone() {

		return ((Player1.Size() == 0 || Player2.Size() == 0) && PlayerPot.Size() == 0);

	}

}
