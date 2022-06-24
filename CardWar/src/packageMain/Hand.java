package packageMain;

import java.util.ArrayList;
import java.util.Random;

public class Hand {

	private ArrayList<Integer> handList;
	private Random rand;

	public Hand() {

		handList = new ArrayList<Integer>();
		rand = new Random();

	}

	public void AddCard(int card) {

		handList.add(card);

	}

	public int RemoveCard() {

		return handList.remove(0);

	}

	public boolean IsEmpty() {

		return handList.isEmpty();

	}

	public int Size() {

		return handList.size();

	}

	public int TopCard() {

		return handList.get(0);

	}

	public void ShuffleHand() {

		ArrayList<Integer> tempList = new ArrayList<Integer>();

		while (!handList.isEmpty()) {

			tempList.add(handList.remove(rand.nextInt(handList.size())));

		}

		while (!tempList.isEmpty()) {

			handList.add(tempList.remove(0));

		}

	}

}
