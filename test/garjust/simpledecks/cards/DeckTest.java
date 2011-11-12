package garjust.simpledecks.cards;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import garjust.simpledecks.SimpleDecksException;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	private Deck<Card> fiveCardDeck;
	private Deck<Card> emptyDeck;
	private Deck<Card> oneCardDeck;
	private int[] shuffleArray;
	
	@Before
	public void setup() throws Exception {		
		emptyDeck = new Deck<Card>();
		oneCardDeck = new Deck<Card>();
		oneCardDeck.addCard(mock(Card.class));
		fiveCardDeck = new Deck<Card>();
		for (int i = 0; i < 5; i++) {
			fiveCardDeck.addCard(mock(Card.class));
		}
		shuffleArray = new int[5];
	}
	
	@Test
	public void deckShouldBeEmpty() throws Exception {
		assertTrue("The deck should not have cards", emptyDeck.isEmpty());
	}
	
	@Test
	public void deckShouldHaveCards() throws Exception {
		assertFalse("The deck should have cards", fiveCardDeck.isEmpty());
	}
	
	@Test
	public void decksShouldBeTheAppropriateSize() throws Exception {
		assertEquals("The empty deck has size zero", emptyDeck.countCards(), 0);
		assertEquals("The one card deck has size 1", oneCardDeck.countCards(), 1);
		assertEquals("The five card deck has size 5", fiveCardDeck.countCards(), 5);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenAddingNullCard() throws Exception {
		emptyDeck.addCard(null);
	}
	
	@Test
	public void deckShouldHaveACardAfterAddingACard() throws Exception {
		Deck<Card> deck = new Deck<Card>();
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
	public void shouldThrowExceptionShufflingEmptyDeck() throws Exception {
		emptyDeck.shuffle(shuffleArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithIncorrectShuffleArraySize() throws Exception {
		oneCardDeck.shuffle(shuffleArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithNullShuffleArray() throws Exception {
		oneCardDeck.shuffle(null);
	}
	
	@Test
	public void shouldShuffle() throws Exception {
		fiveCardDeck.shuffle(shuffleArray);
	}
}
