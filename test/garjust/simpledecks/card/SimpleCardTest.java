package garjust.simpledecks.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleCardTest {

	private SimpleCard card;
	private SimpleCard cardWithValue;
	
	@Before
	public void setup() {
		card = new SimpleCard(Suit.DIAMOND, Rank.FOUR);
		cardWithValue = new SimpleCard(32, Suit.SPADE, Rank.SEVEN);
	}

	@Test
	public void shouldHaveCreatedCardProperly() throws Exception {
		assertEquals("The cards value is the expected", card.value(), 0);
		assertEquals("The cards suit is the expected", card.suit(), Suit.DIAMOND);
		assertEquals("The cards rank is the expected", card.rank(), Rank.FOUR);
		assertEquals("The cards value is the expected", cardWithValue.value(), 32);
		assertEquals("The cards suit is the expected", cardWithValue.suit(), Suit.SPADE);
		assertEquals("The cards rank is the expected", cardWithValue.rank(), Rank.SEVEN);
	}
	
	@Test
	public void shouldMakeProperComparisonsOfBasicCards() throws Exception {
		assertTrue("Same suit, same rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).compareTo(new SimpleCard(Suit.CLUB, Rank.QUEEN)) == 0);
		assertTrue("Same suit, lesser rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).compareTo(new SimpleCard(Suit.CLUB, Rank.KING)) < 0);
		assertTrue("Same suit, greater rank", new SimpleCard(Suit.CLUB, Rank.KING).compareTo(new SimpleCard(Suit.CLUB, Rank.QUEEN)) > 0);
		assertTrue("lesser suit, same rank", new SimpleCard(Suit.DIAMOND, Rank.QUEEN).compareTo(new SimpleCard(Suit.HEART, Rank.QUEEN)) < 0);
		assertTrue("Different cards handled correctly", new SimpleCard(Suit.HEART, Rank.ACE).compareTo(new Card(7)) < 0);
	}
	
	@Test
	public void shouldGiveCorrectEquivalenceResult() throws Exception {
		assertTrue("Same suit, same rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).equals(new SimpleCard(Suit.CLUB, Rank.QUEEN)));
		assertFalse("Same suit, lesser rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).equals(new SimpleCard(Suit.CLUB, Rank.KING)));
		assertFalse("Same suit, greater rank", new SimpleCard(Suit.CLUB, Rank.KING).equals(new SimpleCard(Suit.SPADE, Rank.JACK)));
		assertFalse("lesser suit, same rank", new SimpleCard(Suit.DIAMOND, Rank.QUEEN).equals(new SimpleCard(Suit.HEART, Rank.QUEEN)));
		assertFalse("null", new SimpleCard(Suit.DIAMOND, Rank.QUEEN).equals(null));
	}
}
