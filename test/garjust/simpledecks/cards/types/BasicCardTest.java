package garjust.simpledecks.cards.types;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasicCardTest {

	private BasicCard card;
	
	@Before
	public void setup() {
		card = new BasicCard(Suit.DIAMOND, Rank.FOUR);
	}

	@Test
	public void shouldHaveCreated() throws Exception {
		assertEquals("The cards suit is the expected", card.suit, Suit.DIAMOND);
		assertEquals("The cards rank is the expected", card.rank, Rank.FOUR);
	}
	
	@Test
	public void shouldMakeProperComparisonsOfBasicCards() throws Exception {
		
	}
}
