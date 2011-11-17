package garjust.simpledecks.cardhandlers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;
import garjust.simpledecks.deck.SimpleDeck;

import org.junit.Before;
import org.junit.Test;

public class CardHolderTest {
	
	private CardHolder<Card> cardHolder;
	private SimpleDeck<Card> mockedDeck;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		cardHolder = new CardHolder<Card>();
		mockedDeck = mock(SimpleDeck.class);
		cardHolder.hand = mockedDeck;
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWhenAddingNullCard() throws Exception {
		cardHolder.recieveCard(null);
	}

	@Test
	public void shouldHaveHadACardAddedToHand() throws Exception {
		Card card = mock(Card.class);
		cardHolder.recieveCard(card);
		verify(mockedDeck).addCard(card);
	}
}
