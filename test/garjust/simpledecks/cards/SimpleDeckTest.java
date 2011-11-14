package garjust.simpledecks.cards;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import garjust.simpledecks.SimpleDecksException;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class SimpleDeckTest {
	
	private FreeDeck<Card> emptyDeck;
	private FreeDeck<Card> oneCardDeck;
	private FreeDeck<Card> fiveCardDeck;
	private int[] orderArray;
	
	@Before
	public void before() throws Exception {
		emptyDeck = new SimpleDeck<Card>();
		oneCardDeck = new SimpleDeck<Card>();
		oneCardDeck.addCard(mock(Card.class));
		fiveCardDeck = new SimpleDeck<Card>();
		for (int i = 0; i < 5; i++) {
			fiveCardDeck.addCard(mock(Card.class));
		}
		orderArray = new int[5];
		for (int i = 0; i < orderArray.length; i++) {
			orderArray[orderArray.length - 1 - i] = i;
		}
	}
	
	@Test
	public void shouldBeEmpty() throws Exception {
		assertTrue("The deck should not have cards", emptyDeck.isEmpty());
	}
	
	@Test
	public void shouldHaveCards() throws Exception {
		assertFalse("The deck should have cards", fiveCardDeck.isEmpty());
	}
	
	@Test
	public void shouldBeTheAppropriateSizes() throws Exception {
		assertEquals("The empty deck has size zero", emptyDeck.size(), 0);
		assertEquals("The one card deck has size 1", oneCardDeck.size(), 1);
		assertEquals("The five card deck has size 5", fiveCardDeck.size(), 5);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenAddingNullCard() throws Exception {
		emptyDeck.addCard(null);
	}
	
	@Test
	public void shouldHaveACardAfterAddingACard() throws Exception {
		SimpleDeck<Card> deck = new SimpleDeck<Card>();
		assertTrue("Deck should not have any cards, it was just created", deck.isEmpty());
		deck.addCard(mock(Card.class));
		assertTrue("Deck should have a card now", !deck.isEmpty());
	}
	
	@Test
	public void shouldAddCardInRandomLocation() throws Exception {
		FreeDeck<Card> hundredCardDeck = new SimpleDeck<Card>();
		Card[] cardTracker = new Card[100];
		for (int i = 0; i < 100; i++) {
			Card card = mock(Card.class);
			hundredCardDeck.addCard(card);
			cardTracker[i] = card;
		}
		fail();
	}
	
	@Test
	public void shouldHaveAnEmptyDeckAfterTakingOneCardFromOneCardDeck() throws Exception {
		oneCardDeck.popCard();
		assertTrue("Deck should be empty since it only had one card and it was taken", oneCardDeck.isEmpty());
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenTakingCardFromEmptyDeck() throws Exception {
		emptyDeck.popCard();
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenTryingToPollCardWithBadIndex() throws Exception {
		fiveCardDeck.pollCard(fiveCardDeck.size());
	}
	
	@Test
	public void shouldNotRemoveCardAfterPoll() throws Exception {
		LinkedList<Card> cards = (LinkedList<Card>) fiveCardDeck.cards();
		Card card = cards.get(1);
		assertTrue("Should have correct size", fiveCardDeck.size() == 5);
		assertEquals("Should contain the card", card, fiveCardDeck.pollCard(1));
		assertTrue("Should have correct size after poll", fiveCardDeck.size() == 5);
		assertTrue("Deck should still have the card that was polled", cards.contains(card));
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenTryingToRetrieveCardWithBadIndex() throws Exception {
		fiveCardDeck.retrieveCard(fiveCardDeck.size());
	}
	
	@Test
	public void shouldRemoveCardAfterRetrieve() throws Exception {
		LinkedList<Card> cards = (LinkedList<Card>) fiveCardDeck.cards();
		Card card = cards.get(1);
		assertTrue("Should have correct size", fiveCardDeck.size() == 5);
		assertEquals("Should be the same card", card, fiveCardDeck.retrieveCard(1));
		assertTrue("Should have correct size after get", fiveCardDeck.size() == 4);
		assertFalse("Deck should no longer have the card that was get", fiveCardDeck.cards().contains(card));
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionOrderingEmptyDeck() throws Exception {
		emptyDeck.order(orderArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithIncorrectOrderArraySize() throws Exception {
		oneCardDeck.order(orderArray);
	}

	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithNullOrderArray() throws Exception {
		fiveCardDeck.order(null);
	}
	
	@Test
	public void shouldOrderCardsBackwards() throws Exception {
		Deck<Card> deck = new SimpleDeck<Card>();
		Card[] deckOrdered = new Card[5];
		for (int i = 0; i < deckOrdered.length; i++) {
			Card card = mock(Card.class);
			deck.addCard(card);
			deckOrdered[orderArray[i]] = card;
		}
		for (int i = 0; i < 5; i++) {
			assertFalse(deck.pollCard(i) == deckOrdered[i]);
		}
		deck.order(orderArray);
		for (int i = 0; i < 5; i++) {
			assertEquals(deck.pollCard(i), deckOrdered[i]);
		}
	}
	
	@Test
	public void shouldOrderCards() throws Exception {
		fail();
	}
}
