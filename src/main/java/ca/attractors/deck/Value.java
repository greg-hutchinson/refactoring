package ca.attractors.deck;

public enum Value {
	ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

	public String toString() {
		String string = super.toString();
		String rest = string.toLowerCase().substring(1);
		return string.substring(0, 1) + rest;
	}

}
