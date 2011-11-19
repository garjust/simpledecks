package garjust.simpledecks.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.SimpleCardDeckFactory.SimpleCardDeckType;
import garjust.simpledecks.deck.FreeDeck;
import garjust.simpledecks.deck.SimpleDeck;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class SimpleCardDeckFactoryTest {
	
	private SimpleCardDeckFactory factory;
	private FreeDeck<SimpleCard> deck;

	@Before
	public void before() {
		factory = new SimpleCardDeckFactory();
		deck = new SimpleDeck<SimpleCard>();
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenBuildingWithNullDeck() throws Exception {
		factory.build(SimpleCardDeckType.SIMPLE, null);
	}
	
	@Test
	public void shouldCleanPassedInDeckBeforeBuilding() throws Exception {
		SimpleCard card = mock(SimpleCard.class);
		deck.addCard(card);
		factory.build(SimpleCardDeckType.SIMPLE, deck);
		assertFalse("Deck should not contain the card", deck.cards().contains(card));
	}
	
	@Test
	public void shouldBuildSimpleDeck() throws Exception {
		deck = factory.build(SimpleCardDeckType.SIMPLE);
		LinkedList<SimpleCard> cards = (LinkedList<SimpleCard>) deck.cards();
		assertEquals("Deck should have 52 cards", deck.size(), 52);
		for (int i = 0; i < deck.size() - 1; i++) {
			for (int j = i + 1; j < deck.size(); j++) {
				assertFalse("Card " + i + " should not equal card " + j, cards.get(i).equals(cards.get(j)));
			}
		}
	}

	@Test
	public void shouldBuildBlackjackDeck() throws Exception {
		factory.build(SimpleCardDeckType.BLACKJACK, deck);
		LinkedList<SimpleCard> cards = (LinkedList<SimpleCard>) deck.cards();
		assertEquals("Deck should have 52 cards", deck.size(), 52);
		for (int i = 0; i < deck.size(); i++) {
			assertEquals("Card " + i + " should have correct blackjack value", cards.get(i).value(), SimpleCardDeckFactory.BLACKJACK_VALUES[i % 13]);
		}
	}
}
