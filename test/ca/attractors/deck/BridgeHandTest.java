package ca.attractors.deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ca.attractors.deck.Card.*;
public class BridgeHandTest {

	@Test
	public void testGetHighCardPoints()  {
		BridgeHand hand = new BridgeHand();
		hand.addCard(getAceOfHearts());
		assertEquals(4, hand.getHighCardPoints());
		hand.addCard(getKingOfHearts());
		assertEquals(7, hand.getHighCardPoints());
	}

	@Test
	public void testCanOpen1Heart()  {
		BridgeHand hand = new BridgeHand();
		hand.addCard(getAceOfHearts());
		hand.addCard(getKingOfHearts());
		hand.addCard(getQueenOfHearts());
		hand.addCard(getJackOfHearts());
		hand.addCard(getNineOfHearts());
		assertFalse(hand.canOpen1Heart());
		hand.addCard(getJackOfClubs());
		assertTrue(hand.canOpen1Heart());
	}

}
