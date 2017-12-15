package deckOfCards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck is where we bring the 52 cards together. Here we have the methods to
 * deal hands of Blackjack and a way of shuffling the deck when the deck gets
 * low.
 * 
 */

public class Deck
{

	private ArrayList<Card> theDeck;
	private int cardPosition;
	private Random randNum;
	private String[] cardSuits =
	{ "Hearts", "Diamonds", "Spades", "Clubs" };
	private String[] faces =
	{ "J", "Q", "K" };

	/**
	 * Constructs a 52 card deck that is unshuffled. Deck will be composed of
	 * cards ordered from 2-A, Hearts to Clubs
	 */
	public Deck()
	{
		this.theDeck = new ArrayList<>();
		this.cardPosition = 0;
		this.randNum = new Random();
		this.fillTheDeck();
	}

	/**
	 * Returns the Deck as an ArrayList
	 * 
	 * @return ArrayList the Deck itself
	 */
	public ArrayList<Card> getDeck()
	{
		return this.theDeck;
	}

	/**
	 * Returns the current position of the card in the deck (i.e. 10 will return
	 * the 10th card in the deck)
	 * 
	 * @return int where we are currently positioned in the deck
	 */
	public int getCardPosition()
	{
		return this.cardPosition;
	}

	/**
	 * Returns the next Card in the Deck. Throws an exception if asked for a
	 * card outside the deck.
	 * 
	 * @return Card the next Card in the Deck
	 */
	public Card getNextCard()
	{

		if (this.cardPosition > 51)
		{
			throw new IndexOutOfBoundsException("Out of Cards!");
		}
		return this.theDeck.get(this.cardPosition++);

	}

	/**
	 * Calls the methods responsible for filling the initial deck with the
	 * correct quantity of each type of card
	 */
	private void fillTheDeck()
	{
		this.createNumberCards();
		this.createFaceCards();
		this.createAces();
	}

	/**
	 * Fills the deck with the appropriate amount of number cards; All cards
	 * 2-10; one in each suit
	 */
	private void createNumberCards()
	{

		for (int x = 2; x < 11; x++)
		{

			for (int y = 0; y < 4; y++)
			{

				this.theDeck.add(new NumberCard(this.cardSuits[y], x));
			}
		}
	}

	/**
	 * Fills the deck with the appropriate amount of face cards; All cards J, Q,
	 * and K; one in each suit
	 */
	private void createFaceCards()
	{

		for (int x = 0; x < 3; x++)
		{

			for (int y = 0; y < 4; y++)
			{

				this.theDeck.add(new FaceCard(this.cardSuits[y], this.faces[x]));
			}
		}
	}

	/**
	 * Fills the deck with the appropriate amount of Aces; one in each suit
	 */
	private void createAces()
	{

		for (int y = 0; y < 4; y++)
		{

			this.theDeck.add(new Aces(this.cardSuits[y]));
		}
	}

	/** Rearranges the deck into a random order */
	public void shuffle()
	{

		// for debugging only
		// System.out.println("-----------------------SHUFFLING--------------------------------");

		this.prepDeckForShuffle();

		// new list to hold our reordered cards
		ArrayList<Card> shuffledCards = new ArrayList<>();

		// while we still have cards
		while (!this.theDeck.isEmpty())
		{

			// select a random number within the size of our current list
			int selectedCard = this.randNum.nextInt(this.theDeck.size());

			// take that card and add it to our shuffledCards list
			shuffledCards.add(this.theDeck.get(selectedCard));

			/*
			 * then remove it from our current deck so the next time we go
			 * through our loop we will have less cards to choose from
			 */
			this.theDeck.remove(selectedCard);
		}

		// set our deck to our newly reordered one
		this.theDeck = shuffledCards;
	}

	/**
	 * Ensures deck is prepared to be shuffled. Card position is reset to 0 and
	 * all Ace values are converted back to 11
	 */
	private void prepDeckForShuffle()
	{
		// reset our counter for getNextCard
		this.cardPosition = 0;

		// turn all the aces back to 11
		this.revertAcesTo11();
	}

	/**
	 * Finds all the Aces in a deck and converts their value to 11 if their
	 * value had been previously changed to 1
	 */
	private void revertAcesTo11()
	{

		for (Card eachCard : this.theDeck)
		{

			if (eachCard instanceof Aces)
			{

				Aces anAce = (Aces) eachCard;
				anAce.valueEleven();
			}
		}
	}

	/** Prints to the console each card in its current order */
	public void showDeck()
	{

		for (int x = 0; x < 52; x++)
		{
			System.out.println(this.getNextCard());
		}
	}
}
