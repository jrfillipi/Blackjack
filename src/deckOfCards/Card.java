package deckOfCards;

import java.util.Arrays;

/**
 * This abstract class contains all of the getter and setter methods for Card.
 * Each child class will either be a number, ace, or face card. This class also
 * has a method which can check if the suit of a card is valid by being either
 * Hearts, Diamonds, Spades, or Clubs.
 * 
 * @author RossWeinstein
 */
public abstract class Card
{

	private String suit;
	private String cardFace;
	private int value;
	private String[] cardSuits =
	{ "Hearts", "Diamonds", "Spades", "Clubs" };

	/**
	 * Constructs a card without provided suit, face, and value
	 * 
	 * @param suit
	 *            the suit of the card. Must be Hearts, Diamonds, Spades, or
	 *            Clubs
	 * @param face
	 *            the face of the card. Must be 2-10, J, Q, K, A
	 * @param value
	 *            how many points the card is worth
	 */
	public Card(String suit, String face, int value)
	{
		this.suit = suit;
		this.cardFace = face;
		this.value = value;
	}

	/**
	 * All the important information about each instance of Card
	 * 
	 * @return String the Card's face, suit, and value
	 */
	@Override
	public String toString()
	{
		return "Card: " + this.cardFace + " of " + this.suit + "; Value: " + this.value;
	}

	/**
	 * Returns the suit of a given Card
	 * 
	 * @return String returns "Hearts", "Diamonds", "Spades", or "Clubs"
	 */
	public String getSuit()
	{
		return this.suit;
	}

	/**
	 * Returns the face of a given Card
	 * 
	 * @return String the card face
	 */
	public String getCardFace()
	{
		return this.cardFace;
	}

	/**
	 * Returns the value of a given Card
	 * 
	 * @return int the value of the Card
	 */
	public int getCardValue()
	{
		return this.value;
	}

	/**
	 * Sets the suit of a given Card
	 * 
	 * @param suit
	 *            suit of the card: "Hearts", "Diamonds", "Spades", or "Clubs"
	 */
	public void setSuit(String suit)
	{
		this.suit = this.validSuit(suit);
	}

	/**
	 * Sets the value of a given Card
	 * 
	 * @param value
	 *            what value the Card will be
	 */
	protected void setCardValue(int value)
	{
		this.value = value;
	}

	/**
	 * Sets the face of a given Card
	 * 
	 * @param cardFace
	 *            what face the Card will have
	 */
	public void setCardFace(String cardFace)
	{
		this.cardFace = cardFace;
	}

	/**
	 * Checks if the Card's suit is either Hearts, Diamonds, Spades, or Clubs
	 * 
	 * @param suit
	 *            A suit for the check to see if its "Hearts", "Diamonds",
	 *            "Spades", or "Clubs"
	 * @return String Returns a valid suit if all goes well
	 * @exception IllegalArgumentException
	 *                if the suit given is not "Hearts", "Diamonds", "Spades",
	 *                "Clubs"
	 */
	private String validSuit(String suit)
	{

		if (Arrays.asList(this.cardSuits).contains(suit))
		{
			return suit;
		}
		else
		{
			throw new IllegalArgumentException("Suit is " + suit + ". Must Be Hearts, Diamonds, Spades, or Clubs.");
		}
	}
}
