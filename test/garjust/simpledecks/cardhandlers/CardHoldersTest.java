package garjust.simpledecks.cardhandlers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;

import org.junit.Before;
import org.junit.Test;

public class CardHoldersTest {

	private CardHolders<Card> cardHolders;
	private CardHolder<Card> mockedPlayer;
	private CardHolder<Card> mockedPlayerTwo;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		cardHolders = new CardHolders<Card>();
		mockedPlayer = mock(CardHolder.class);
		mockedPlayerTwo = mock(CardHolder.class);
	}

	@Test
	public void shouldHaveAPlayer() throws Exception {
		cardHolders.addCardHolder(mockedPlayer);
		assertTrue(cardHolders.size() == 1);
	}
	
	@Test
	public void shouldHaveRemovedPlayer() throws Exception {
		cardHolders.addCardHolder(mockedPlayer);
		cardHolders.removeCardHolder(mockedPlayer);
		assertTrue(cardHolders.size() == 0);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionRemovingNonExistingPlayer() throws Exception {
		cardHolders.addCardHolder(mockedPlayer);
		cardHolders.removeCardHolder(mockedPlayerTwo);
	}
}
