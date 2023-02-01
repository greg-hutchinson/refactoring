package ca.attractors.deck;

import java.util.ArrayList;
import java.util.List;

public class BridgeHand {
	public List<Card> cards = new ArrayList<Card>();
	
	public void addCard(Card aCard) {
		cards.add(aCard);
	}
	
	public int getHighCardPoints() {
		int sum = 0;
		for (Card card : cards) {
			sum = sum + getCardValue(card);
		}
		return sum;
	}

	private int getCardValue(Card aCard) {
		if (aCard.getIntValue() == 1)
			return 4;
		if (aCard.getIntValue() < 11)
			return 0;
		return aCard.getIntValue() - 10;
	}
	
	public List<Card> getCardsInSuit(Suit aSuit) {
		List<Card> suitedCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (card.getSuit() == aSuit) 
				suitedCards.add(card);
		}
		return suitedCards;		
	}
	public int getLengthPoints() {
		int sum = 0;
		for (Suit suit : Suit.values()) {
			sum = sum + getLengthPointsFor(getCardsInSuit(suit));			
		}
		return sum;
	}
	
	public int getTotalPoints() {
		return getHighCardPoints() + getLengthPoints();
	}
	
	private int getLengthPointsFor(List<Card> aListOfCards) {
		if (aListOfCards.size() < 5)
			return 0;
		return aListOfCards.size() - 4;
	}
	
	public boolean canOpen1Heart() {
		List<Card> suitedCards = getCardsInSuit(Suit.HEARTS);
		if (suitedCards.size() < 5)
			return false;
		if (getTotalPoints() >= 12)
			return true;
		return false;
	}
	
	public boolean canOpen1Nt() {
		return isFlatHand() && isNoTrumpRange();
	}
	
	private boolean isNoTrumpRange() {
		if (getHighCardPoints() < 15)
			return false;
		return getHighCardPoints() <= 17;
	}
	private boolean isFlatHand() {
		int numberOfDoubletons = 0;
		for (Suit suit : Suit.values()) {
			List<Card> suitedCards = getCardsInSuit(suit);
			int size = suitedCards.size();
			if (size < 2)
				return false;
			if (size > 5)
				return false;
			if (size == 2)
				numberOfDoubletons++;
		}
		return numberOfDoubletons <= 1;
		
	}
	

}
