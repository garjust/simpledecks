package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

import java.util.LinkedList;

public class Deck<E extends Card> extends Cards<E> {
	
	private final LinkedList<E> cards;
	
	public Deck() {
		this.cards = new LinkedList<E>();
	}
	
	public Card popCard() throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to deal a card from an empty deck");
		}
		return cards.pop();
	}
	
	@Override
	public Cards<E> addCard(E card) {
		cards.push(card);
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
