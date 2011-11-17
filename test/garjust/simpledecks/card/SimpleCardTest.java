package garjust.simpledecks.card;

import static org.junit.Assert.*;
import garjust.simpledecks.card.SimpleCard;
import garjust.simpledecks.card.Rank;
import garjust.simpledecks.card.Suit;

import org.junit.Before;
import org.junit.Test;

public class SimpleCardTest {

	private SimpleCard card;
	
	@Before
	public void setup() {
		card = new SimpleCard(Suit.DIAMOND, Rank.FOUR);
	}

	@Test
	public void shouldHaveCreated() throws Exception {
		assertEquals("The cards suit is the expected", card.suit(), Suit.DIAMOND);
		assertEquals("The cards rank is the expected", card.rank(), Rank.FOUR);
	}
	
	@Test
	public void shouldMakeProperComparisonsOfBasicCards() throws Exception {
		assertTrue("Same suit, same rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).compareTo(new SimpleCard(Suit.CLUB, Rank.QUEEN)) == 0);
		assertTrue("Same suit, lesser rank", new SimpleCard(Suit.CLUB, Rank.QUEEN).compareTo(new SimpleCard(Suit.CLUB, Rank.KING)) < 0);
		assertTrue("Same suit, greater rank", new SimpleCard(Suit.CLUB, Rank.KING).compareTo(new SimpleCard(Suit.CLUB, Rank.QUEEN)) > 0);
		assertTrue("lesser suit, same rank", new SimpleCard(Suit.DIAMOND, Rank.QUEEN).compareTo(new SimpleCard(Suit.HEART, Rank.QUEEN)) < 0);
	}
}
