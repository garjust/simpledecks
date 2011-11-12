package garjust.simpledecks.cardhandlers;

import static org.mockito.Mockito.*;
import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Hand;

import org.junit.Before;
import org.junit.Test;

public class CardHolderTest {
	
	private CardHolder<Card> cardHolder;
	private Hand<Card> mockedHand;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		cardHolder = new CardHolder<Card>();
		mockedHand = mock(Hand.class);
		cardHolder.hand = mockedHand;
	}

	@Test
	public void shouldHaveHadACardAddedToHand() throws Exception {
		Card card = new Card();
		cardHolder.recieveCard(card);
		verify(mockedHand).addCard(card);
	}
}
