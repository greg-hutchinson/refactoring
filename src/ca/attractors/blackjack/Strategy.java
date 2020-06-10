package ca.attractors.blackjack;

import java.util.List;

public interface Strategy {

	public void play(int aSimulation);
	public List<BlackJackHand> getPlayerHands();
	public BlackJackHand getDealerHand();

}
