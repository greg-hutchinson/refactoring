package ca.attractors.blackjack;

import ca.attractors.deck.Card;
import ca.attractors.deck.Shoe;

import java.util.ArrayList;
import java.util.List;

public class StrategyImpl implements Strategy {
	private BlackJackHand dealer;
	private List<BlackJackHand> playerHands;
	private Shoe shoe;

	@Override
	public void play(int aSimulation) {
		ensureInitializedShoe();
		dealer = new BlackJackHand();
		playerHands = new ArrayList<BlackJackHand>();
		BlackJackHand player = new BlackJackHand();
		player.addCard(shoe.dealCard());
		dealer.addCard(shoe.dealCard());
		player.addCard(shoe.dealCard());
		playerHands.add(player);
		playPlayerHands();
		playDealer();
	}

	private void playDealer() {
		while (dealer.getTotal() < 17 && !dealer.isBusted())
			dealer.addCard(shoe.dealCard());
	}

	private void playPlayerHands() {
		boolean done = false;
		while (!done) {
			done = true;
			for (BlackJackHand blackJackHand : new ArrayList<BlackJackHand>(playerHands)) {
				if (playHand(blackJackHand))
					done = false;
			}
		}
	}

	private boolean playHand(BlackJackHand aBlackJackHand) {
		if (aBlackJackHand.isBusted())
			return false;
		if (aBlackJackHand.getTotal() >= 17)
			return false;

		if (shouldSplit(aBlackJackHand)) {
			playerHands.add(aBlackJackHand.split());
			return true;
		}
		if (shouldDouble(aBlackJackHand)) {
			return true;
		}
		if (aBlackJackHand.getTotal() <= 11) {
			aBlackJackHand.addCard(shoe.dealCard());
			return true;
		}

		if (dealer.getTotal() < 7) {
			return false;
		}
		aBlackJackHand.addCard(shoe.dealCard());
		return true;
	}

	private boolean shouldDouble(BlackJackHand aBlackJackHand) {
		return false;
	}

	private boolean shouldSplit(BlackJackHand aBlackJackHand) {
		if (!aBlackJackHand.canSplit())
			return false;
		if (dealer.getTotal() == 11)
			return false;
		if (aBlackJackHand.getCards().get(0).isAce())
			return true;
		if (dealer.getTotal() >= 9)
			return false;
		if (aBlackJackHand.getCards().get(0).getIntValue() <= 3)
			return true;
		if (aBlackJackHand.getCards().get(0).getIntValue() == 8)
			return true;
		return false;
	}

	public List<BlackJackHand> getPlayerHands() {
		return playerHands;
	}

	public BlackJackHand getDealerHand() {
		return dealer;
	}

	private void ensureInitializedShoe() {
		if (requiresNewShoe()) {
			shoe = new Shoe(4);
			removeCards();
			shoe.shuffle();
		}
	}

	private void removeCards() {
		shoe.removeAll(Card.getFiveOfClubs());
		shoe.removeAll(Card.getFiveOfDiamonds());
		shoe.removeAll(Card.getFiveOfHearts());
		shoe.removeAll(Card.getFiveOfSpades());

		shoe.removeAll(Card.getFourOfClubs());
		shoe.removeAll(Card.getFourOfDiamonds());
		shoe.removeAll(Card.getFourOfHearts());
		shoe.removeAll(Card.getFourOfSpades());
	}

	private boolean requiresNewShoe() {
		if (shoe == null)
			return true;
		return shoe.getSize() < 52;
	}
}
