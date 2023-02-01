package ca.attractors.deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest  {
	
	private static final Card ACE_OF_CLUBS = new Card(Value.ACE, Suit.CLUBS);
	private static final Card DEUCE_OF_CLUBS = new Card(Value.DEUCE, Suit.CLUBS);
	private static final Card ACE_OF_DIAMONDS = new Card(Value.ACE, Suit.DIAMONDS);
	private static final Card KING_OF_DIAMONDS = new Card(Value.KING, Suit.DIAMONDS);
	private static final Card QUEEN_OF_HEARTS = new Card(Value.QUEEN, Suit.HEARTS);
	private static final Card JACK_OF_HEARTS = new Card(Value.JACK, Suit.HEARTS);
	private static final Card TEN_OF_SPADES = new Card(Value.TEN, Suit.SPADES);

	@Test
	public void testToString() throws Exception {
		assertEquals("Ace of Clubs",ACE_OF_CLUBS.toString());		
	}

	@Test
	public void testForCoverage() throws Exception {
		Suit.valueOf("CLUBS");
		Value.valueOf("ACE");
	}

	@Test
	public void testIsClub() {
		assertTrue(ACE_OF_CLUBS.isClub());
		assertFalse(KING_OF_DIAMONDS.isClub());
	}

	@Test
	public void testIsDiamond() {
		assertFalse(ACE_OF_CLUBS.isDiamond());
		assertTrue(KING_OF_DIAMONDS.isDiamond());
	}

	@Test
	public void testIsHeart() {
		assertFalse(ACE_OF_CLUBS.isHeart());
		assertTrue(QUEEN_OF_HEARTS.isHeart());
	}

	@Test
	public void testIsSpade() {
		assertFalse(ACE_OF_CLUBS.isSpade());
		assertTrue(TEN_OF_SPADES.isSpade());
	}

	@Test
	public void testIsAce() {
		assertTrue(ACE_OF_CLUBS.isAce());
		assertFalse(TEN_OF_SPADES.isAce());
	}

	@Test
	public void testIsFace() {
		assertFalse(ACE_OF_CLUBS.isFace());
		assertTrue(KING_OF_DIAMONDS.isFace());
		assertTrue(QUEEN_OF_HEARTS.isFace());
		assertTrue(JACK_OF_HEARTS.isFace());
	}

	@Test
	public void testGetAllCards() throws Exception {
		assertEquals(52, Card.getAllCards().size());
	}

	@Test
	public void testGetRawValue() {
		assertEquals(1, ACE_OF_CLUBS.getIntValue());
		assertEquals(13, KING_OF_DIAMONDS.getIntValue());
	}

	@Test
	public void testEqualsAndHashCode() throws Exception {
		Card otherAceOfClubs = new Card(Value.ACE, Suit.CLUBS);
		assertEquals(ACE_OF_CLUBS, otherAceOfClubs);
		assertFalse(ACE_OF_CLUBS.equals(ACE_OF_DIAMONDS));
		assertFalse(ACE_OF_CLUBS.equals(new Object()));
		assertEquals(ACE_OF_CLUBS.hashCode(), otherAceOfClubs.hashCode());
	}

	@Test
	public void testCompareTo() throws Exception {
		assertTrue(ACE_OF_CLUBS.compareTo(ACE_OF_CLUBS) == 0);
		assertTrue(ACE_OF_CLUBS.compareTo(ACE_OF_DIAMONDS) < 0);
		assertTrue(ACE_OF_CLUBS.compareTo(DEUCE_OF_CLUBS) < 0);
	}
}
