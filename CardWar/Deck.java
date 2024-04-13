package CardWar;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Integer> deckList;
	private Random rand;

	public Deck() {

		rand = new Random();

		ConstructDeck();

	}

	private void ConstructDeck() {

		deckList = new ArrayList<Integer>();

		final int cardMax = 15;
		final int suitMax = 4;

		int card;
		int suit;

		for (card = 2; card < cardMax; card++) {

			for (suit = 0; suit < suitMax; suit++) {

				deckList.add(card);

			}

		}

	}

	public int DeckSize() {

		return deckList.size();

	}

	public boolean DeckEmpty() {

		return deckList.isEmpty();

	}

	public int DealCard() {

		return deckList.remove(rand.nextInt(deckList.size()));

	}

}
