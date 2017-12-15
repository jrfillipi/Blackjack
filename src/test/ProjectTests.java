package test;

import static org.junit.Assert.*;
import org.junit.Test;
import deckOfCards.Aces;
import deckOfCards.Card;
import deckOfCards.Deck;
import deckOfCards.FaceCard;
import deckOfCards.NumberCard;
import player.Dealer;
import player.Gambler;
import player.Hand;

/**
 * This Class runs all the JUnit tests. Here are 10 tests which check various
 * methods within this application.
 * 
 */

public class ProjectTests
{

	// Some Cards to use in the testing
	Card aceOfSpades = new Aces("Spades");
	Card kingOfClubs = new FaceCard("Clubs", "K");
	Card eightOfSpades = new NumberCard("Spades", 8);
	Card tenOfHearts = new NumberCard("Hearts", 10);
	Card fiveOfDiamonds = new NumberCard("Diamonds", 5);
	Card sixOfClubs = new NumberCard("Clubs", 6);
	Card fourOfClubs = new NumberCard("Clubs", 4);

	@Test
	public void testIfBlackjack()
	{

		Gambler player = new Gambler();
		player.hit(aceOfSpades);
		player.hit(kingOfClubs);

		assertEquals(true, blackjackWin(player.getHand()));
	}

	@Test
	public void testIfAceIsEleven()
	{
		assertEquals(11, aceOfSpades.getCardValue());

	}

	@Test
	public void testIfPlayerWonHand()
	{

		Gambler player = new Gambler();
		player.hit(tenOfHearts);
		player.hit(eightOfSpades);

		Dealer dealer = new Dealer();
		dealer.hit(fiveOfDiamonds);
		dealer.hit(kingOfClubs);

		assertEquals(true, wonHand(player, dealer));
	}

	@Test
	public void testIfDealerBeatPlayer()
	{

		Gambler player = new Gambler();
		player.hit(fiveOfDiamonds);
		player.hit(eightOfSpades);

		Dealer dealer = new Dealer();
		dealer.hit(aceOfSpades);
		dealer.hit(kingOfClubs);

		assertEquals(false, wonHand(player, dealer));
	}

	@Test
	public void testIfDealerBusted()
	{

		Dealer dealer = new Dealer();
		dealer.hit(eightOfSpades);
		dealer.hit(fiveOfDiamonds);
		dealer.hit(tenOfHearts);

		assertEquals(true, dealer.getHand().isHandOver21());
	}

	@Test
	public void testIfDeckIsComprisedOf52Cards()
	{

		Deck theDeck = new Deck();

		assertEquals(52, theDeck.getDeck().size());
	}
	
	@Test
	public void testIfDeckIsComprisedOfMultipleOf52Cards()
	{

		Deck theDeck = new Deck(2);

		assertEquals(104, theDeck.getDeck().size());
	}

	@Test
	public void testIfPlayerCanDoubleDown11()
	{

		Gambler player = new Gambler();

		player.hit(fiveOfDiamonds);
		player.hit(sixOfClubs);

		assertEquals(true, player.getHand().canDoubleDown());
	}

	@Test
	public void testIfPlayerCanDoubleDown10()
	{

		Gambler player = new Gambler();

		player.hit(fiveOfDiamonds);
		player.hit(fiveOfDiamonds);

		assertEquals(true, player.getHand().canDoubleDown());
	}

	@Test
	public void testIfPlayerCanDoubleDown9()
	{

		Gambler player = new Gambler();

		player.hit(fiveOfDiamonds);
		player.hit(fourOfClubs);

		assertEquals(true, player.getHand().canDoubleDown());
	}

	
	
	@Test
	public void testIfDealerHitsOnSoft17()
	{
		// changed the assert to false to denote dealer standing on all hands >=
		// 17.
		Dealer dealer = new Dealer();

		dealer.hit(aceOfSpades);
		dealer.hit(sixOfClubs);

		assertEquals(false, dealer.dealerHits());
	}

	@Test
	public void testIfAcesConvertToOne()
	{

		Gambler player = new Gambler();

		player.hit(eightOfSpades);
		player.hit(aceOfSpades);
		player.hit(fiveOfDiamonds);

		assertEquals(14, player.getHandTotal());
	}

	@Test
	public void testIfCanPlaceBet()
	{

		Gambler player = new Gambler();

		assertEquals(false, player.placeBet(105));
	}

	// Some Private methods that I needed to bring over to test and convert them
	// to public static

	/**
	 * Determine whether there is blackjack -- FROM BLACKJACK.JAVA
	 * 
	 * @param handToCheck
	 *            takes a Player's Hand object
	 * @return boolean returns true if the Hand is a blackjack, consisting of 2
	 *         cards and has a total of 21; false otherwise
	 */
	public static boolean blackjackWin(Hand handToCheck)
	{
		return handToCheck.getCardsDealt().size() == 2 && handToCheck.getHandTotal() == 21;
	}

	/**
	 * Determines whether the gambler beat the dealer -- FROM BLACKJACK.JAVA
	 * 
	 * @param gambler
	 *            Takes a gambler object
	 * @param dealer
	 *            takes a Dealer object
	 * @return boolean returns true if the Gambler won the hand or false if the
	 *         Dealer won the hand
	 */
	public static boolean wonHand(Gambler gambler, Dealer dealer)
	{
		return gambler.getHand().getHandTotal() > dealer.getHand().getHandTotal()
				&& gambler.getHand().getHandTotal() <= 21
				|| gambler.getHand().getHandTotal() <= 21 && dealer.getHand().getHandTotal() > 21;
	}
}
