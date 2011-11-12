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
		assertTrue("Same suit, same rank", new BasicCard(Suit.CLUB, Rank.QUEEN).compareTo(new BasicCard(Suit.CLUB, Rank.QUEEN)) == 0);
		assertTrue("Same suit, lesser rank", new BasicCard(Suit.CLUB, Rank.QUEEN).compareTo(new BasicCard(Suit.CLUB, Rank.KING)) < 0);
		assertTrue("Same suit, greater rank", new BasicCard(Suit.CLUB, Rank.KING).compareTo(new BasicCard(Suit.CLUB, Rank.QUEEN)) > 0);
		assertTrue("lesser suit, same rank", new BasicCard(Suit.DIAMOND, Rank.QUEEN).compareTo(new BasicCard(Suit.HEART, Rank.QUEEN)) < 0);
	}
}
