package garjust.simpledecks.cards.types;

import garjust.simpledecks.cards.Card;

public class BasicCard implements Card, Comparable<BasicCard> {

	public final Suit suit;
	public final Rank rank;

	public BasicCard(final Suit suit, final Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public int compareTo(final BasicCard card) {
		final int suitComparison = suit.compareTo(card.suit);
		final int rankComparison = rank.compareTo(card.rank);
		if (suitComparison == 0) {
			if (rankComparison == 0) {
				return 0;
			} else {
				return rankComparison;
			}
		} else {
			return suitComparison;
		}
	}
}
