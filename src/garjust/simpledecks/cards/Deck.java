package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

import java.util.LinkedList;

public class Deck<E extends Card> extends Cards<E> {
	
	protected final LinkedList<E> cards;
	
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
	public Cards<E> addCard(E card) throws SimpleDecksException {
		if (card == null) {
			throw new SimpleDecksException("Attempt to add null card to deck");
		}
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

	@Override
	public Cards<E> shuffle(int[] shuffleArray) throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to shuffle an empty deck");
		} else if (shuffleArray == null || countCards() != shuffleArray.length) {
			throw new SimpleDecksException("Attempt to shuffle using null or invalid shuffle array");
		}
		return this;
	}
}
