package ca.attractors.deck;

import ca.attractors.images.ImageLoader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Card implements Comparable<Card> {
	private Value value;
	private Suit suit;
	
	Card(Value aValue, Suit aSuit){
		value = aValue;
		suit = aSuit;
	}

	@Override
	public String toString() {
		return value.toString() + " of " + suit.toString();
	}
	
	public boolean isClub() {
		return suit == Suit.CLUBS;
	}
	public boolean isDiamond() {
		return suit == Suit.DIAMONDS;
	}
	public boolean isHeart() {
		return suit == Suit.HEARTS;
	}
	public boolean isSpade() {
		return suit == Suit.SPADES;
	}
	
	public Value getValue() {
		return value;
	}

	public boolean isAce() {
		return getValue() == Value.ACE;
	}
	
	public boolean isFace() {
		if (getValue() == Value.KING)
			return true;
		if (getValue() == Value.QUEEN)
			return true;
		return getValue() == Value.JACK;
	}
	

	static Collection<Card> getAllCards() {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Value value: Value.values())
				cards.add(new Card(value,suit));
		}
		return cards;
	}
	
	public int getIntValue() {
		return value.ordinal() + 1;
	}
	
	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof Card))
			return false;
		if (this == anOtherObject)
			return true;
		Card other = (Card) anOtherObject;
		if (suit != other.suit)
			return false;
		return value == other.value;
	}
	@Override
	public int hashCode() {
		return suit.hashCode() + value.hashCode();
	}
	
	protected Suit getSuit() {
		return suit;
	}
	
	public int compareTo(Card anOtherCard) {
		if (this.equals(anOtherCard))
			return 0;
		if (suit != anOtherCard.suit)
			return suit.ordinal() - anOtherCard.suit.ordinal();
		return value.ordinal() - anOtherCard.value.ordinal();
	}

	public ImageIcon getImageIcon() {
		return new ImageLoader(getImageFilename()).getImageIcon();
	}

	public String getImageFilename() {
		String filename = Integer.toString(asIndex());
		if (asIndex() < 10)
			filename = "0" + filename;
		return filename + ".JPG";
	}
	
	private int asIndex() {
		int base = suit.ordinal() * 13; 
		return base + value.ordinal() + 1;
	}
    public static Card getAceOfClubs() {return new Card(Value.ACE, Suit.CLUBS);}
    public static Card getDeuceOfClubs() {return new Card(Value.DEUCE, Suit.CLUBS);}
    public static Card getThreeOfClubs() {return new Card(Value.THREE, Suit.CLUBS);}
    public static Card getFourOfClubs() {return new Card(Value.FOUR, Suit.CLUBS);}
    public static Card getFiveOfClubs() {return new Card(Value.FIVE, Suit.CLUBS);}
    public static Card getSixOfClubs() {return new Card(Value.SIX, Suit.CLUBS);}
    public static Card getSevenOfClubs() {return new Card(Value.SEVEN, Suit.CLUBS);}
    public static Card getEightOfClubs() {return new Card(Value.EIGHT, Suit.CLUBS);}
    public static Card getNineOfClubs() {return new Card(Value.NINE, Suit.CLUBS);}
    public static Card getTenOfClubs() {return new Card(Value.TEN, Suit.CLUBS);}
    public static Card getJackOfClubs() {return new Card(Value.JACK, Suit.CLUBS);}
    public static Card getQueenOfClubs() {return new Card(Value.QUEEN, Suit.CLUBS);}
    public static Card getKingOfClubs() {return new Card(Value.KING, Suit.CLUBS);}

    public static Card getAceOfDiamonds() {return new Card(Value.ACE, Suit.DIAMONDS);}
    public static Card getDeuceOfDiamonds() {return new Card(Value.DEUCE, Suit.DIAMONDS);}
    public static Card getThreeOfDiamonds() {return new Card(Value.THREE, Suit.DIAMONDS);}
    public static Card getFourOfDiamonds() {return new Card(Value.FOUR, Suit.DIAMONDS);}
    public static Card getFiveOfDiamonds() {return new Card(Value.FIVE, Suit.DIAMONDS);}
    public static Card getSixOfDiamonds() {return new Card(Value.SIX, Suit.DIAMONDS);}
    public static Card getSevenOfDiamonds() {return new Card(Value.SEVEN, Suit.DIAMONDS);}
    public static Card getEightOfDiamonds() {return new Card(Value.EIGHT, Suit.DIAMONDS);}
    public static Card getNineOfDiamonds() {return new Card(Value.NINE, Suit.DIAMONDS);}
    public static Card getTenOfDiamonds() {return new Card(Value.TEN, Suit.DIAMONDS);}
    public static Card getJackOfDiamonds() {return new Card(Value.JACK, Suit.DIAMONDS);}
    public static Card getQueenOfDiamonds() {return new Card(Value.QUEEN, Suit.DIAMONDS);}
    public static Card getKingOfDiamonds() {return new Card(Value.KING, Suit.DIAMONDS);}

    public static Card getAceOfHearts() {return new Card(Value.ACE, Suit.HEARTS);}
    public static Card getDeuceOfHearts() {return new Card(Value.DEUCE, Suit.HEARTS);}
    public static Card getThreeOfHearts() {return new Card(Value.THREE, Suit.HEARTS);}
    public static Card getFourOfHearts() {return new Card(Value.FOUR, Suit.HEARTS);}
    public static Card getFiveOfHearts() {return new Card(Value.FIVE, Suit.HEARTS);}
    public static Card getSixOfHearts() {return new Card(Value.SIX, Suit.HEARTS);}
    public static Card getSevenOfHearts() {return new Card(Value.SEVEN, Suit.HEARTS);}
    public static Card getEightOfHearts() {return new Card(Value.EIGHT, Suit.HEARTS);}
    public static Card getNineOfHearts() {return new Card(Value.NINE, Suit.HEARTS);}
    public static Card getTenOfHearts() {return new Card(Value.TEN, Suit.HEARTS);}
    public static Card getJackOfHearts() {return new Card(Value.JACK, Suit.HEARTS);}
    public static Card getQueenOfHearts() {return new Card(Value.QUEEN, Suit.HEARTS);}
    public static Card getKingOfHearts() {return new Card(Value.KING, Suit.HEARTS);}

    public static Card getAceOfSpades() {return new Card(Value.ACE, Suit.SPADES);}
    public static Card getDeuceOfSpades() {return new Card(Value.DEUCE, Suit.SPADES);}
    public static Card getThreeOfSpades() {return new Card(Value.THREE, Suit.SPADES);}
    public static Card getFourOfSpades() {return new Card(Value.FOUR, Suit.SPADES);}
    public static Card getFiveOfSpades() {return new Card(Value.FIVE, Suit.SPADES);}
    public static Card getSixOfSpades() {return new Card(Value.SIX, Suit.SPADES);}
    public static Card getSevenOfSpades() {return new Card(Value.SEVEN, Suit.SPADES);}
    public static Card getEightOfSpades() {return new Card(Value.EIGHT, Suit.SPADES);}
    public static Card getNineOfSpades() {return new Card(Value.NINE, Suit.SPADES);}
    public static Card getTenOfSpades() {return new Card(Value.TEN, Suit.SPADES);}
    public static Card getJackOfSpades() {return new Card(Value.JACK, Suit.SPADES);}
    public static Card getQueenOfSpades() {return new Card(Value.QUEEN, Suit.SPADES);}
    public static Card getKingOfSpades() {return new Card(Value.KING, Suit.SPADES);}

	
}
