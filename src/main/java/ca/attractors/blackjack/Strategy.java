package ca.attractors.blackjack;

import java.util.List;

public interface Strategy {

	void play(int aSimulation);
	List<BlackJackHand> getPlayerHands();
	BlackJackHand getDealerHand();

}
