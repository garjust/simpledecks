package garjust.simpledecks.cards;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import garjust.simpledecks.SimpleDecksException;

import org.junit.Before;
import org.junit.Test;

public class CardsTest {
	
	private Cards<Card> cards;
	private int[] shuffleArray;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() throws Exception {
		cards = mock(Cards.class);
		shuffleArray = new int[5];
		when(cards.shuffle(any(int[].class))).thenCallRealMethod();
		when(cards.isEmpty()).thenReturn(false);
		when(cards.countCards()).thenReturn(shuffleArray.length);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionShufflingEmptyDeck() throws Exception {
		when(cards.isEmpty()).thenReturn(true);
		cards.shuffle(shuffleArray);
	}
	
	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithIncorrectShuffleArraySize() throws Exception {
		when(cards.countCards()).thenReturn(2);
		cards.shuffle(shuffleArray);
	}

	@Test(expected=SimpleDecksException.class)
	public void shouldThrowExceptionWithNullShuffleArray() throws Exception {
		cards.shuffle(null);
	}
	
	@Test
	public void shouldShuffleCardsSuccessfully() throws Exception {
		cards.shuffle(shuffleArray);
		verify(cards).shuffleCards(shuffleArray);
	}
}
