package deckOfCards;

/**
 * For the Aces in each deck. Acess can have a value of 11 or 1.
 * 
 */

public class Aces extends Card
{

	/**
	 * Constructs a Ace card with a value of 11 and face of 'A'. If suit is
	 * something other than "Hearts", "Diamonds", "Spades", or "Clubs", program
	 * will throw an IllegalArgumentException
	 * 
	 * @param suit
	 *            This denotes what suit the ace will be
	 */
	public Aces(String suit)
	{
		super(suit, "A", 11);
	}

	/** Sets the value of an Ace to 1 */
	public void valueOne()
	{
		super.setCardValue(1);
	}

	/** Sets the value of an Ace to 11. An Ace value is 11 by default */
	public void valueEleven()
	{
		super.setCardValue(11);
	}
}
