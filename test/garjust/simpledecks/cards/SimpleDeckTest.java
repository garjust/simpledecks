package garjust.simpledecks.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import garjust.simpledecks.SimpleDecksException;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class SimpleDeckTest {
	
	private FreeDeck<Card> emptyDeck;
	private FreeDeck<Card> oneCardDeck;
	private FreeDeck<Card> fiveCardDeck;
	private int[] simeplOrderArray;
	
	@Before
	public void before() throws Exception {
		emptyDeck = new SimpleDeck<Card>();
		oneCardDeck = new SimpleDeck<Card>();
		oneCardDeck.addCard(mock(Card.class));
		fiveCardDeck = new SimpleDeck<Card>();
		for (int i = 0; i < 5; i++) {
			fiveCardDeck.addCard(mock(Card.class));
		}
		simeplOrderArray = new int[5];
		for (int i = 0; i < simeplOrderArray.length; i++) {
			simeplOrderArray[i] = i;
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
		final int deckSize = 10;
		FreeDeck<Card> deck = new SimpleDeck<Card>();
		Collection<Card> cards = (Collection<Card>) deck.cards();
		int[] position = new int[100];
		Card card = mock(Card.class);
		for(int i = 0; i < position.length; i++) {
			cards.clear();
			for(int j = 0; j < deckSize; j++) {
				cards.add(mock(Card.class));
			}
			deck.addCard(card);
			int j = 0;
			for (Card checkCard: cards) {
				if (checkCard == card) {
					position[i] = j;
				}
				j++;
			}
		}
		int check, checkNext;
		for(int i = 0; i < position.length - 1; i++) {
			check = position[i];
			checkNext = position[i + 1];
			if (check != checkNext) {
				return;
			}
		}
		fail("The card was always added to the same place");
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
		assertTrue("Should have correct size after retrieval", fiveCardDeck.size() == 4);
		assertFalse("Deck should no longer have the card that was retrieved", fiveCardDeck.cards().contains(card));
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionOrderingEmptyDeck() throws Exception {
		emptyDeck.order(simeplOrderArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithIncorrectOrderArraySize() throws Exception {
		oneCardDeck.order(simeplOrderArray);
	}

	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithNullOrderArray() throws Exception {
		fiveCardDeck.order(null);
	}
	
	@Test
	public void shouldOrderCardsBackwards() throws Exception {
		final int deckSize = 4;
		int[] backwardOrderArray = new int[deckSize];
		for (int i = 0; i < deckSize; i++) {
			backwardOrderArray[backwardOrderArray.length - 1 - i] = i;
		}
		
		FreeDeck<Card> deck = new SimpleDeck<Card>();
		LinkedList<Card> deckCards = (LinkedList<Card>) deck.cards();
		Card[] deckOrdered = new Card[deckSize];
		for (int i = 0; i < deckSize; i++) {
			Card card = mock(Card.class);
			deckCards.add(card);
			deckOrdered[backwardOrderArray[i]] = card;
		}
		
		for (int i = 0; i < deckSize; i++) {
			assertFalse("Cards at location " + i + " should not be equal", deckCards.get(i) == deckOrdered[i]);
		}
		deck.order(backwardOrderArray);
		for (int i = 0; i < deckSize; i++) {
			assertEquals("Cards at location " + i + " should be equal", deckCards.get(i), deckOrdered[i]);
		}
	}
	
	@Test
	public void shouldOrderCardsWithRandomOrderArray() throws Exception {
		final int deckSize = 10;
		int[] randomOrderArray = new int[deckSize];
		FreeDeck<Card> deck = new SimpleDeck<Card>();
		LinkedList<Card> deckCards = (LinkedList<Card>) deck.cards();
		Card[] deckOrdered = new Card[deckSize];
		for (int i = 0; i < deckSize; i++) {
			randomOrderArray[i] = i;
			Card card = mock(Card.class);
			deckCards.add(card);
			deckOrdered[i] = card;
		}
		for (int i = deckSize - 1; i > 0; i--) {
			int swap = (int) (Math.random() * (i + 1));
			int temp_integer = randomOrderArray[i];
			randomOrderArray[i] = randomOrderArray[swap];
			randomOrderArray[swap] = temp_integer;
			Card temp_card = deckOrdered[i];
			deckOrdered[i] = deckOrdered[swap];
			deckOrdered[swap] = temp_card;
		}
		deck.order(randomOrderArray);
		for (int i = 0; i < deckSize; i++) {
			assertEquals("Cards at location " + i + " should be equal", deckCards.get(i), deckOrdered[i]);
		}
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenDuplicateCardAdded() throws Exception {
		Card card = mock(Card.class);
		oneCardDeck.addCard(card);
		oneCardDeck.addCard(card);
	}
}
