package garjust.simpledecks.card;

public class SimpleCard extends Card {

	private final Suit suit;
	private final Rank rank;
	
	public SimpleCard(final int i, final Suit suit, final Rank rank) {
		super(i);
		this.suit = suit;
		this.rank = rank;
	}

	public SimpleCard(final Suit suit, final Rank rank) {
		super(0);
		this.suit = suit;
		this.rank = rank;
	}

	public Suit suit() {
		return suit;
	}
	
	public Rank rank() {
		return rank;
	}

	@Override
	public int compareTo(final Card untypedCard) {
		if (!(untypedCard instanceof SimpleCard)) {
			return super.compareTo(untypedCard);
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
		if (card.suit() == suit && card.rank() == rank) {
			return true;
		}
		return false;
	}
}
