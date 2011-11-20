package garjust.simpledecks.cardhandlers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import garjust.simpledecks.card.Card;
import garjust.simpledecks.deck.FreeDeck;
import garjust.simpledecks.deck.SimpleDeck;

import org.junit.Before;
import org.junit.Test;

public class DealerTest {

	private CardHolder<Card> mockCardHolderOne;
	private CardHolder<Card> mockCardHolderTwo;
	private CardHolders<Card> cardHolders;
	private FreeDeck<Card> deck;
	private Dealer<Card> dealer;

	@SuppressWarnings("unchecked")
	@Before
	public void before() throws Exception {
		mockCardHolderOne = mock(CardHolder.class);
		mockCardHolderTwo = mock(CardHolder.class);
		cardHolders = new CardHolders<Card>();
		deck = new SimpleDeck<Card>();
		for (int i = 0; i < 10; i++) {
			deck.addCard(mock(Card.class));
		}
		dealer = new Dealer<Card>(deck, cardHolders);
		cardHolders.addCardHolder(mockCardHolderOne);
		cardHolders.addCardHolder(mockCardHolderTwo);
	}
	
	@Test
	public void shouldDealEntireDeckToCardHolders() throws Exception {
		dealer.deal();
		assertTrue("Deck should be empty after being delt", deck.isEmpty());
		verify(mockCardHolderOne, times(5)).recieveCard(any(Card.class));
		verify(mockCardHolderTwo, times(5)).recieveCard(any(Card.class));
	}
}
