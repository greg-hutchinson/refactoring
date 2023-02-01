package ca.attractors.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
	private List<Card> cards;

	public Shoe(int aNumberOfDecks) {
		this(getCardsForDecks(aNumberOfDecks));
	}

	private static List<Card> getCardsForDecks(int aNumberOfDecks) {
		List<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < aNumberOfDecks; i++) {
			cards.addAll(Card.getAllCards());
		}
		return cards;
	}

	public Shoe(List<Card> aListOfCards) {
		cards = aListOfCards;
	}
	
	public boolean removeCard(Card aCard) {
		if (!cards.contains(aCard))
			throw new Error("Card does not exist " + aCard);
		return cards.remove(aCard);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public int getSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void removeAll(Card aCard) {
		boolean done = false;
		while (!done) {
			done = cards.remove(aCard);
		}
	}

}
