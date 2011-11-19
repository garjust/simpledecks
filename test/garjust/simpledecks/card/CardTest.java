package garjust.simpledecks.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
	
	@Before
	public void setup() {
		card = new Card(5);
	}

	@Test
	public void shouldHaveCreatedCardProperly() throws Exception {
		assertEquals("The cards value is the expected", card.value(), 5);
	}
	
	@Test
	public void shouldMakeProperComparisonsOfCards() throws Exception {
		assertTrue("Same values", card.compareTo(new Card(5)) == 0);
		assertTrue("Lesser value", card.compareTo(new Card(6)) < 0);
		assertFalse("null", card.equals(null));
	}
	
	@Test
	public void shouldGiveCorrectEquivalenceResult() throws Exception {
		assertTrue("Same values", card.equals(new Card(5)));
		assertFalse("Different values", card.equals(new Card(6)));
		assertFalse("null", card.equals(null));
	}
}
