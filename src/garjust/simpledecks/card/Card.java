package garjust.simpledecks.card;

public class Card implements Comparable<Card>{
	
	private final int value;
	
	public Card(final int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
	
	public int compareTo(final Card card) {
		if (value() == card.value()) {
			return 0;
		} else if (value() < card.value()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	@Override
	public boolean equals(final Object object) {
		if (object == null || !(object instanceof Card)) {
			return false;
		}
		Card card = (Card) object;
		if (card.value() == value()) {
			return true;
		}
		return false;
	}
}
