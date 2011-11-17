package garjust.simpledecks.card;

public abstract class Card implements Comparable<Card>{
	
	private final int value;
	
	public Card(final int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
	
	public int compareTo(final Card card) {
		if (value == card.value) {
			return 0;
		} else if (value < card.value) {
			return -1;
		} else {
			return 1;
		}
	}
}
