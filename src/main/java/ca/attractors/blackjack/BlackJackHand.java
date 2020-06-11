package ca.attractors.blackjack;

import ca.attractors.deck.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJackHand implements Comparable<BlackJackHand> {
	private static final int BUST = -1;
	private List<Card> cards = new ArrayList<Card>();

	private boolean split = false;

	public boolean isBusted() {
		return getBasicValue() == BUST;
	}


	public boolean isBlackJack() {
		return getNumberOfCards() == 2 && getTotal() == 21;
	}

	public boolean isBlackJackV2() {
		if (getNumberOfCards() == 2)
			return false;
		int value = 0;
		for (Card card : cards) {
			int temp = card.getIntValue();
			if (card.isFace())
				temp = 10;
			if (card.isAce())
				temp =  11;
			value += temp;
		}
		return value == 21;
	}

	public boolean isBlackJackV1() {
		if (cards.size() != 2)
			return false;
		Card card1 = cards.get(0);
		Card card2 = cards.get(1);
		if (card1.getIntValue() == 1)  //Ace
			if (card2.getIntValue() >= 10) {  //10,11,12,13 Ten thru King
				return true;
			}
		if ((card1.getIntValue() >= 10) && (card2.getIntValue() == 1))
			return true;
		return false;
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public void addCard(Card aCard) {
		if (isBusted())
			throw new UnsupportedOperationException("can not add cards to a broken hand. Hand already has a value of " + getBasicValue());
		cards.add(aCard);
	}

	public int getTotal() {
		if (isBusted())
			return -1;
		return getBasicValue();
	}


	public BlackJackHand split() {
		if (!canSplit())
			throw new UnsupportedOperationException("Can not split a hand with these cards " + cards.toString() );
		Card splitCard = cards.remove(1);
		becomeSplit();
		BlackJackHand newHand = new BlackJackHand();
		newHand.addCard(splitCard);
		newHand.becomeSplit();
		return newHand;
	}
	
	public boolean canHit() {
		if (isBusted())
			return false;
		if (!isSplit())
			return true;
		if (!getFirstCard().isAce())
			return true;
		return cards.size() == 1;
	}

	private boolean isSplit() {
		return split;
	}

	private void becomeSplit() {
		split = true;
	}

	public boolean canSplit() {
		if (cards.size() != 2)
			return false;
		return getCardValueFor(getFirstCard()) == getCardValueFor(getSecondCard());
	}

	private Card getFirstCard() {
		return cards.get(0);
	}

	private Card getSecondCard() {
		return cards.get(1);
	}

	private int getBasicValue() {
		int value = getMaximumValue();
		if (value <= 21)
			return value;
		int numberOfAces = getNumberOfAces();
		while (numberOfAces-- > 0) {
			value -= 10;
			if (value <= 21)
				return value;
		}
		return BUST;
	}

	private int getMaximumValue() {
		int value = 0;
		for (Card card : cards) {
			value += getCardValueFor(card);
		}
		return value;
	}

	private int getNumberOfAces() {
		int numberOfAces = 0;
		for (Card card : cards) {
			if (card.isAce())
				numberOfAces++;
		}
		return numberOfAces;
	}

	private int getCardValueFor(Card card) {
		if (card.isFace())
			return 10;
		if (card.isAce())
			return 11;
		return card.getIntValue();
	}

	private int getNumberOfCards() {
		return cards.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackJackHand(" + getValueString() + ") ");
		builder.append(cards.toString());
		return builder.toString();
	}

	private String getValueString() {
		if (isBusted())
			return "BUSTED";
		return "" + getTotal();
	}

	@Override
	public int compareTo(BlackJackHand anOtherHand) {
		if (getTotal() > anOtherHand.getTotal())
			return 1;
		if (getTotal() < anOtherHand.getTotal())
			return -1;
		if (isBlackJack() && anOtherHand.isBlackJack())
			return 0;
		if (isBlackJack())
			return 1;
		if (anOtherHand.isBlackJack())
			return -1;
		return 0;
	}
}
