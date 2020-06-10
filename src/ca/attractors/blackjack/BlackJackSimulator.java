package ca.attractors.blackjack;

import java.util.List;

public class BlackJackSimulator {
	private int simulations = 0;
	private Strategy strategy;
	private int playerWins = 0;
	private int push = 0;
	private int dealerWins = 0;
	private int blackJacks = 0;

	public static void main(String[] args) {
		new BlackJackSimulator().run(1000000, new StrategyImpl());
	}
	
	private void run(int aNumberOfSimulations, Strategy aStrategy) {
		simulations = aNumberOfSimulations;
		strategy = aStrategy;
		simulate();
		report();
	}

	private void report() {
		System.out.println("There were " + simulations + " tried.");
		System.out.println("There were " + push + " pushes.");
		System.out.println("The dealer won " + dealerWins + " times.");
		System.out.print("The player won " + playerWins + " times and "
				+ blackJacks + " blackJacks ");
		double wins = blackJacks * 1.5 + playerWins;
		double total = wins + dealerWins;
		System.out.println("for a total of " + wins + " with a percentage of " + wins / total );
	}

	private void simulate() {
		for (int i = 0; i < simulations; i++) {
			strategy.play(i);
			tally();
		}
	}

	private void tally() {
		BlackJackHand dealer = strategy.getDealerHand();
		List<BlackJackHand> playerHands = strategy.getPlayerHands();
		for (BlackJackHand playerHand : playerHands) {
			tallyPlayerToDealer(playerHand, dealer);
		}
	}

	private void tallyPlayerToDealer(BlackJackHand playerHand,
			BlackJackHand dealer) {
		if (playerHand.compareTo(dealer) == 0)
			push++;
		if (playerHand.compareTo(dealer) < 0)
			dealerWins++;
		if (playerHand.compareTo(dealer) > 0) {
			if (playerHand.isBlackJack())
				blackJacks++;
			else
				playerWins++;
		}
	}
}
