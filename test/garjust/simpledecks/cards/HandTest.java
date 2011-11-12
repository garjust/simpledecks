package garjust.simpledecks.cards;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Hand;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
	
	private Hand<Card> fiveCardHand;
	private Hand<Card> emptyHand;
	private Hand<Card> oneCardHand;
	private int[] shuffleArray;
	
	@Before
	public void setup() throws Exception {		
		emptyHand = new Hand<Card>();
		oneCardHand = new Hand<Card>();
		oneCardHand.addCard(mock(Card.class));
		fiveCardHand = new Hand<Card>();
		for (int i = 0; i < 5; i++) {
			fiveCardHand.addCard(mock(Card.class));
		}
		shuffleArray = new int[5];
		for (int i = 0; i < shuffleArray.length; i++) {
			shuffleArray[i] = shuffleArray.length - 1 - i;
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
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenAddingNullCard() throws Exception {
		emptyHand.addCard(null);
	}
	
	@Test
	public void deckShouldHaveACardAfterAddingACard() throws Exception {
		Hand<Card> hand = new Hand<Card>();
		assertTrue("Hand should not have any cards, it was just created", hand.isEmpty());
		hand.addCard(mock(Card.class));
		assertTrue("Hand should have a card now", !hand.isEmpty());
	}
	
	@Test
	public void shouldShuffleCards() throws Exception {
		Hand<Card> hand = new Hand<Card>();
		Card[] handShuffled = new Card[5];
		for (int i = 0; i < 5; i++) {
			Card card = mock(Card.class);
			hand.addCard(card);
			handShuffled[4 - i] = card;
		}
		hand.shuffle(shuffleArray);
		for (int i = 0; i < 5; i++) {
			assertEquals(hand.card(i), handShuffled[i]);
		}
	}
}
