package garjust.simpledecks.cards;

import java.util.ArrayList;

public class Hand<E extends Card> extends Cards<E> {
	
	private final ArrayList<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	@Override
	public Cards<E> addCard(Card card) {
		cards.add(card);
		return this;
	}
	
	@Override
	public int countCards() {
		return cards.size();
	}

	@Override
	public boolean isEmpty() {
		return cards.isEmpty();
	}
}
