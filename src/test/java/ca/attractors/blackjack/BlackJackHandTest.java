package ca.attractors.blackjack;

import ca.attractors.deck.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BlackJackHandTest {
	private static final Card KING_OF_CLUBS = Card.getKingOfClubs();
	private static final Card ACE_OF_CLUBS = Card.getAceOfClubs();
	private static final Card DEUCE_OF_CLUBS = Card.getDeuceOfClubs();

	@Test
	public void testGetValueWithoutAces() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		assertEquals(10, hand.getTotal());
		hand.addCard(DEUCE_OF_CLUBS);
		assertEquals(12, hand.getTotal());
	}

	@Test
	public void testGetValueWithAces() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		assertEquals(10, hand.getTotal());
		hand.addCard(ACE_OF_CLUBS);
		assertEquals(21, hand.getTotal());
		hand.addCard(ACE_OF_CLUBS);
		assertEquals(12, hand.getTotal());
	}


	@Test
	public void testGetValueForBustedHand() {
		BlackJackHand hand = getBustedHand();
		assertTrue(hand.isBusted());
		assertEquals(-1, hand.getTotal());
	}

	@Test
	public void testIsBlackJack() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(ACE_OF_CLUBS);
		assertFalse(hand.isBlackJack());
		hand.addCard(KING_OF_CLUBS);
		assertTrue(hand.isBlackJack());

		hand.addCard(KING_OF_CLUBS);
		assertFalse(hand.isBlackJack());
		hand.addCard(ACE_OF_CLUBS);
		assertTrue(hand.isBusted());
		assertFalse(hand.isBlackJack());
	}

	@Test
	public void testIsBusted() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(ACE_OF_CLUBS);
		assertFalse(hand.isBusted());

		hand.addCard(ACE_OF_CLUBS);
		assertTrue(hand.isBusted());

		//If you don't understand this part, ask your instructor
		try {
			hand.addCard(ACE_OF_CLUBS);
			fail("Expected exception did not occur");
		} catch (UnsupportedOperationException e) {
		}
	}

	private BlackJackHand getBustedHand() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(DEUCE_OF_CLUBS);
		return hand;
	}

	//This is an optional test method. If you are feeling energetic ...
	@Test
	public void testToString() {
		BlackJackHand hand = new BlackJackHand();
		assertEquals("BlackJackHand(0) []", hand.toString());
		hand.addCard(ACE_OF_CLUBS);
		assertEquals("BlackJackHand(11) [Ace of Clubs]", hand.toString());
		hand.addCard(ACE_OF_CLUBS);
		assertEquals("BlackJackHand(12) [Ace of Clubs, Ace of Clubs]", hand.toString());
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		assertEquals("BlackJackHand(BUSTED) [Ace of Clubs, Ace of Clubs, King of Clubs, King of Clubs]", hand.toString());
	}
	//This is an optional test method. If you are feeling energetic ...

	@Test
	public void testCompareTo() {
		BlackJackHand hand = new BlackJackHand();
		BlackJackHand hand2 = new BlackJackHand();
		assertEquals(0, hand.compareTo(hand2));

		hand.addCard(ACE_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);

		hand2.addCard(ACE_OF_CLUBS);
		hand2.addCard(KING_OF_CLUBS);
		assertEquals(0, hand.compareTo(hand2));
	
		hand2 = new BlackJackHand();
		hand2.addCard(ACE_OF_CLUBS);
		hand2.addCard(DEUCE_OF_CLUBS);
		hand2.addCard(Card.getEightOfClubs());
		assertEquals(1, hand.compareTo(hand2));
		
		hand = new BlackJackHand();
		hand.addCard(DEUCE_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		assertEquals(-1, hand.compareTo(hand2));
	}

	@Test
	public void testCanSplit() {
		BlackJackHand hand = new BlackJackHand();
		assertFalse(hand.canSplit());
		hand.addCard(ACE_OF_CLUBS);
		hand.addCard(ACE_OF_CLUBS);
		assertTrue(hand.canSplit());

		hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(Card.getTenOfClubs());
		assertTrue(hand.canSplit());
	}

	@Test
	public void testSplit() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(Card.getTenOfClubs());
		BlackJackHand hand2 = hand.split();
		assertEquals(0, hand.compareTo(hand2));
	}

	@Test
	public void testCanHit() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(KING_OF_CLUBS);
		hand.addCard(ACE_OF_CLUBS);
		assertTrue(hand.canHit());
		hand.addCard(ACE_OF_CLUBS);
		assertFalse(hand.canHit());

		hand = new BlackJackHand();
		hand.addCard(ACE_OF_CLUBS);
		hand.addCard(ACE_OF_CLUBS);
		BlackJackHand hand2 = hand.split();
		assertTrue(hand2.canHit());
		hand2.addCard(ACE_OF_CLUBS);
		assertFalse(hand2.canHit());
		assertTrue(hand2.canSplit());
	}
	
}
