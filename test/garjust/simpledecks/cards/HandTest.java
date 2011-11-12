package garjust.simpledecks.cards;

import static org.junit.Assert.*;
import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Hand;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
	
	private Hand fiveCardHand;
	private Hand emptyHand;
	private Hand oneCardHand;
	
	@Before
	public void setup() {		
		emptyHand = new Hand();
		oneCardHand = new Hand();
		oneCardHand.addCard(new Card());
		fiveCardHand = new Hand();
		for (int i = 0; i < 5; i++) {
			fiveCardHand.addCard(new Card());
		}
	}
	
	@Test
	public void handShouldBeEmpty() throws Exception {
		assertTrue("The hand should not have cards", emptyHand.isEmpty());
	}
	
	@Test
	public void handShouldHaveCards() throws Exception {
		assertTrue("The hand should have cards", !fiveCardHand.isEmpty());
	}
	
	@Test
	public void handsShouldBeTheAppropriateSize() throws Exception {
		assertEquals("The empty hand has size zero", emptyHand.countCards(), 0);
		assertEquals("The one card hand has size 1", oneCardHand.countCards(), 1);
		assertEquals("The five card hand has size 5", fiveCardHand.countCards(), 5);
	}
	
	@Test
	public void deckShouldHaveACardAfterAddingACard() throws Exception {
		Hand hand = new Hand();
		assertTrue("Hand should not have any cards, it was just created", hand.isEmpty());
		hand.addCard(new Card());
		assertTrue("Hand should have a card now", !hand.isEmpty());
	}
}
