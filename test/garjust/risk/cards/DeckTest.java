package garjust.risk.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {
	
	@Test(expected=CardException.class)
	public void shouldThrowExceptionWhenDealingNullDeck() throws Exception {
		Deck deck = new Deck();
		deck.deal();
	}
}
