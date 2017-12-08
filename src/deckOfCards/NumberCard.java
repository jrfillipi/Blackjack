package deckOfCards;

/**
 * NumberCard is for Cards 2-10 in a deck.
 * 
 */

public class NumberCard extends Card
{

	/**
	 * Constructs a NumberCard with a value of 2-10. Will throw an
	 * IllegalArgumentException if any value but 2-10 is given for its value and
	 * if any suit is given other than "Hearts", "Diamonds", "Spades", or
	 * "Clubs"
	 * 
	 * @param suit
	 *            The suit of the given card: Hearts, Diamonds, Spades, or Clubs
	 * @param value
	 *            The value of the card, same as the face when it's a NumberCard
	 */
	public NumberCard(String suit, int value)
	{
		super(suit, Integer.toString(value), value);
		this.validCardValue(value);
	}

	/**
	 * Checks that the value of each instance of this class is between 2 and 10
	 * 
	 * @param value
	 *            The value to check; must be between 2 and 10
	 * @return int Returns an int if value is between 2 and 10
	 * @exception IllegalArgumentException
	 *                is thrown is values is not between 2 and 10
	 */
	public int validCardValue(int value)
	{

		if (value >= 2 && value <= 10)
		{
			return value;
		}
		else
		{
			throw new IllegalArgumentException("Card Value is " + value + ". Value Must Be Between 2 and 10.");
		}
	}
}
