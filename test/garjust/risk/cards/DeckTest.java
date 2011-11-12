package garjust.risk.cards;

import static org.junit.Assert.*;
import garjust.risk.players.Player;
import garjust.risk.players.Players;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	private Players players;
	private Deck deck;

	@Before
	public void setup() {
		players = new Players();
		for (int i = 0; i < 4; i++) {
			players.add(new Player());
		}
		
		deck = new Deck();
		for (int i = 0; i < 5; i++) {
			deck.addCard(new Card());
		}
	}
	
	@Test(expected=CardException.class)
	public void shouldThrowExceptionWhenDealingEmptyDeck() throws Exception {
		Deck deck = new Deck();
		deck.dealDeck(players);
	}
	
	@Test(expected=CardException.class)
	public void shouldThrowExceptionWhenDealingToNull() throws Exception {
		Deck deck = new Deck();
		deck.addCard(new Card());
		deck.dealDeck(null);
	}
	
	@Test(expected=CardException.class)
	public void shouldThrowExceptionWhenDealingToEmpty() throws Exception {
		Deck deck = new Deck();
		deck.addCard(new Card());
		deck.dealDeck(new Players());
	}
	
	@Test
	public void deckShouldHaveCards() throws Exception {
		Deck deck = new Deck();
		deck.addCard(new Card());
		fail();
	}
	
	@Test
	public void shouldHaveAnEmptyDeckAfterDealing() throws Exception {
		deck.dealDeck(players);
		assertTrue(deck.noCards());
	}
}
