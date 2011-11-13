package garjust.simpledecks.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import garjust.simpledecks.SimpleDecksException;

import org.junit.Before;
import org.junit.Test;

public class SimpleDeckTest {
	
	private SimpleDeck<Card> emptyDeck;
	private SimpleDeck<Card> oneCardDeck;
	private SimpleDeck<Card> fiveCardDeck;
	private int[] shuffleArray;
	
	@Before
	public void before() throws Exception {
		emptyDeck = new SimpleDeck<Card>();
		oneCardDeck = new SimpleDeck<Card>();
		oneCardDeck.addCard(mock(Card.class));
		fiveCardDeck = new SimpleDeck<Card>();
		for (int i = 0; i < 5; i++) {
			fiveCardDeck.addCard(mock(Card.class));
		}
		shuffleArray = new int[5];
		for (int i = 0; i < shuffleArray.length; i++) {
			shuffleArray[i] = i;
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
	public void shouldGetCardThatWasJustPushed() throws Exception {
		Card card = mock(Card.class);
		fiveCardDeck.addCard(card);
		assertEquals("The card popped from the deck should be the same card", card, fiveCardDeck.popCard());
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
		Card card = mock(Card.class);
		FreeDeck<Card> deck = new SimpleDeck<Card>();
		deck.addCard(mock(Card.class));
		deck.addCard(mock(Card.class));
		deck.addCard(card);
		deck.addCard(mock(Card.class));
		assertTrue("Should have correct size", deck.size() == 4);
		assertEquals("Should be the same card", card, deck.pollCard(1));
		assertTrue("Should have correct size after poll", deck.size() == 4);
		assertTrue("Deck should still have the card that was polled", deck.cards().contains(card));
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenTryingToRetrieveCardWithBadIndex() throws Exception {
		fiveCardDeck.retrieveCard(fiveCardDeck.size());
	}
	
	@Test
	public void shouldRemoveCardAfterRetrieve() throws Exception {
		Card card = mock(Card.class);
		FreeDeck<Card> deck = new SimpleDeck<Card>();
		deck.addCard(mock(Card.class));
		deck.addCard(mock(Card.class));
		deck.addCard(card);
		deck.addCard(mock(Card.class));
		assertTrue("Should have correct size", deck.size() == 4);
		assertEquals("Should be the same card", card, deck.retrieveCard(1));
		assertTrue("Should have correct size after get", deck.size() == 3);
		assertFalse("Deck should no longer have the card that was get", deck.cards().contains(card));
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionShufflingEmptyDeck() throws Exception {
		emptyDeck.shuffle(shuffleArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithIncorrectShuffleArraySize() throws Exception {
		oneCardDeck.shuffle(shuffleArray);
	}

	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithNullShuffleArray() throws Exception {
		fiveCardDeck.shuffle(null);
	}
	
	@Test
	public void shouldShuffleCardsSuccessfully() throws Exception {
		Deck<Card> deck = new SimpleDeck<Card>();
		Card[] deckShuffled = new Card[5];
		for (int i = 0; i < 5; i++) {
			Card card = mock(Card.class);
			deck.addCard(card);
			deckShuffled[i] = card; // NOTE: The decks cards are being popped from the 'end' while the shuffled decks cards are just being iterated
		}
		deck.shuffle(shuffleArray);
		for (int i = 0; i < 5; i++) {
			assertEquals(deck.popCard(), deckShuffled[i]);
		}
	}
}
