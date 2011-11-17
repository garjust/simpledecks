package garjust.simpledecks.card;

public class SimpleCard extends Card {

	public final Suit suit;
	public final Rank rank;

	public SimpleCard(final Suit suit, final Rank rank) {
		super(0);
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public int compareTo(final Card untypedCard) {
		if (!(untypedCard instanceof SimpleCard)) {
			super.compareTo(untypedCard);
		}
		SimpleCard card = (SimpleCard) untypedCard;
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
	
	@Override
	public boolean equals(final Object object) {
		if (object == null || !(object instanceof SimpleCard)) {
			return false;
		}
		SimpleCard card = (SimpleCard) object;
		if (card.suit == suit && card.rank == rank) {
			return true;
		}
		return false;
	}
}
