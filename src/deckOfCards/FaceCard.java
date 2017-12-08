package deckOfCards;

import java.util.Arrays;

/**
 * FaceCard is for Jacks, Queens, and Kings of a deck.
 * 
 */

public class FaceCard extends Card
{

	private String[] faces =
	{ "J", "Q", "K" };

	/**
	 * Constructs a FaceCard with a value of 10. If the face is not "J", "Q",
	 * "K" or if the suit is not "Hearts", "Diamonds", "Spades", or "Clubs" it
	 * will throw an IllegalArgumentException
	 * 
	 * @param suit
	 *            The suit of the given card: Hearts, Diamonds, Spades, or Clubs
	 * @param face
	 *            The face of the give card: J, Q, or K
	 */
	public FaceCard(String suit, String face)
	{
		super(suit, face, 10);
		this.validFace(face);
	}

	/**
	 * Checks that the face of each instance of this class is J, Q, or K
	 * 
	 * @param face
	 *            Checks to see if its J, Q, or K
	 * @return String
	 * @exception IllegalArgumentException
	 *                if passed invalid face
	 */
	private String validFace(String face)
	{

		if (Arrays.asList(this.faces).contains(face))
		{
			return face;
		}
		else
		{
			throw new IllegalArgumentException("Card Face is " + face + ". Face must be J, Q, or K");
		}
	}
}
