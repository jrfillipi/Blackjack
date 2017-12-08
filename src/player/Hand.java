package player;

import java.util.*;

import deckOfCards.Aces;
import deckOfCards.Card;

/**
 * The Hand classes takes care of the operation specific to each hand of
 * Blackjack. It governs what the hands total is, if they Player's total is over
 * 21 and changes the values of the Aces if they need to be converted from 11 to
 * 1.
 *
 */

public class Hand
{

	private ArrayList<Card> hand;
	private int total;

	/** Constructs an empty hand with a total of 0 */
	public Hand()
	{
		this.hand = new ArrayList<>();
		this.total = 0;
	}

	/**
	 * Returns whether the Gambler can Double Down for not
	 * 
	 * @return if the Hand has two cards and their total is 10 or 11 return
	 *         true; false otherwise
	 */
	public boolean canDoubleDown()
	{
		return this.hand.size() == 2 && (this.total == 11 || this.total == 10);
	}

	/**
	 * Hand receives a new Card and updates total
	 * 
	 * @param card
	 *            the Card to be added to the Hand
	 */
	public void cardDealt(Card card)
	{

		this.hand.add(card);
		this.total = this.totalHand();
	}

	/**
	 * Returns the Hand's total value
	 * 
	 * @return int what the Hand's current total is
	 */
	public int getHandTotal()
	{
		return this.total;
	}

	/**
	 * Returns each card within the hand as an ArrayList
	 * 
	 * @return ArrayList all the Cards in the Hand
	 */
	public ArrayList<Card> getCardsDealt()
	{
		return this.hand;
	}

	/**
	 * Returns the value of the hand
	 * 
	 * @return int current value of the hand
	 */
	private int totalHand()
	{

		int handTotal = this.calcHandTotal();

		if (handTotal > 21)
		{
			this.FindAndFlipAces();
			handTotal = this.calcHandTotal();
		}
		return handTotal;
	}

	/**
	 * Calculates the current hand's total
	 * 
	 * @return int the calculated total for the Hand
	 */
	private int calcHandTotal()
	{

		int handTotal = 0;

		for (Card eachCard : this.hand)
		{
			handTotal += eachCard.getCardValue();
		}
		return handTotal;
	}

	/**
	 * Returns whether the hand value is over 21
	 * 
	 * @return boolean if the Hand's total is greater than 21; false otherwise
	 */
	public boolean isHandOver21()
	{
		return calcHandTotal() > 21;
	}

	/**
	 * Loops through the hand and determines whether an Ace needs to be
	 * converted form a value of 11 to a worth of 1
	 */
	public void FindAndFlipAces()
	{

		boolean foundAce = false;
		int position = 0;

		while (position < this.hand.size() && !foundAce)
		{

			// if we're looking at an Ace
			if (this.hand.get(position) instanceof Aces)
			{

				// cast it as an Ace
				Aces theAce = (Aces) this.hand.get(position);

				// if the value is current 11, change it to 1
				if (theAce.getCardValue() == 11)
				{

					theAce.valueOne();
					foundAce = true;
				}
			}
			position++;
		}
	}

	/**
	 * Determines whether the dealer currently has a soft 17 (Ace and 6)
	 * 
	 * @return boolean true if the hand is a soft 17; false otherwise
	 */
	public boolean hasSoft17()
	{
		return this.getHandTotal() == 17 && this.handHasAces();
	}

	/**
	 * Helper method for hasSoft17(). Determines if the Dealer has 17, are one
	 * of those cards an Ace
	 * 
	 * @return boolean true if the hand any Aces; false otherwise
	 */
	private boolean handHasAces()
	{

		boolean hasAce11 = false;

		for (Card eachCard : this.getCardsDealt())
		{

			if (eachCard.getCardValue() == 11)
			{
				hasAce11 = true;
			}
		}
		return hasAce11;
	}
}
