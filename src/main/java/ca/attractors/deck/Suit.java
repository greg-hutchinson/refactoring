package ca.attractors.deck;

public enum Suit {
	CLUBS, DIAMONDS, HEARTS, SPADES;

	public String toString() {
		String string = super.toString();
		String rest = string.toLowerCase().substring(1);
		return string.substring(0, 1) + rest;
	}
}
