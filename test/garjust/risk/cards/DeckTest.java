package garjust.risk.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	private Deck fiveCardDeck;
	private Deck emptyDeck;
	private Deck oneCardDeck;
	
	@Before
	public void setup() {		
		emptyDeck = new Deck();
		oneCardDeck = new Deck();
		oneCardDeck.addCard(new Card());
		fiveCardDeck = new Deck();
		for (int i = 0; i < 5; i++) {
			fiveCardDeck.addCard(new Card());
		}
	}
	
	@Test
	public void deckShouldBeEmpty() throws Exception {
		assertTrue("The deck should not have cards", emptyDeck.isEmpty());
	}
	
	@Test
	public void deckShouldHaveCards() throws Exception {
		assertTrue("The deck should have cards", !fiveCardDeck.isEmpty());
	}
	
	@Test
	public void decksShouldBeTheAppropriateSize() throws Exception {
		assertEquals("The empty deck has size zero", emptyDeck.countCards(), 0);
		assertEquals("The one card deck has size 1", oneCardDeck.countCards(), 1);
		assertEquals("The five card deck has size 5", fiveCardDeck.countCards(), 5);
	}
	
	@Test
	public void deckShouldHaveACardAfterAddingACard() throws Exception {
		Deck deck = new Deck();
		assertTrue("Deck should not have any cards, it was just created", deck.isEmpty());
		deck.addCard(new Card());
		assertTrue("Deck should have a card now", !deck.isEmpty());
	}
	
	@Test
	public void shouldGetCardThatWasJustPushed() throws Exception {
		Card card = new Card();
		fiveCardDeck.addCard(card);
		assertEquals("The card popped from the deck should be the same card", card, fiveCardDeck.popCard());
	}
	
	@Test
	public void shouldHaveAnEmptyDeckAfterTakingOneCardFromOneCardDeck() throws Exception {
		oneCardDeck.popCard();
		assertTrue("Deck should be empty since it only had one card and it was taken", oneCardDeck.isEmpty());
	}
	
	@Test(expected=CardException.class)
	public void shouldThrowExceptionWhenTakingCardFromEmptyDeck() throws Exception {
		emptyDeck.popCard();
	}
}
