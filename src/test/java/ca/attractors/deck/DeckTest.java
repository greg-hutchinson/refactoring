package ca.attractors.deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeckTest {
	@Test
	public void testGetSize() {
		Deck deck = new Deck();
		assertEquals(52, deck.getSize());
		deck.getNextCard();
		assertEquals(51, deck.getSize());
	}

}
