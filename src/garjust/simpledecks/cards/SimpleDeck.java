package garjust.simpledecks.cards;

import java.util.Collection;
import java.util.LinkedList;

import garjust.simpledecks.SimpleDecksException;

public class SimpleDeck<E extends Card> implements Deck<E>, RestrictedDeck<E>, FreeDeck<E> {
	
	protected final LinkedList<E> cards;
	
	public SimpleDeck() {
		this.cards = new LinkedList<E>();
	}
	
	public Collection<E> cards() {
		return cards;
	}
	
	public Deck<E> addCard(E card) throws SimpleDecksException {
		if (card == null) {
			throw new SimpleDecksException("Attempt to add null card to deck");
		}
		cards.push(card);
		return this;
	}
	
	public E popCard() throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to deal a card from an empty deck");
		}
		return cards.pop();
	}
	
	public E pollCard(int i) throws SimpleDecksException {
		if (i >= size()) {
			throw new SimpleDecksException("Attempt to poll card from deck with out of range index");
		}
		return cards.get(i);
	}
	
	public E retrieveCard(int i) throws SimpleDecksException {
		if (i >= size()) {
			throw new SimpleDecksException("Attempt to retrieve card from deck with out of range index");
		}
		E card = cards.get(i);
		cards.remove(i);
		return card;
	}
	
	public int size() {
		return cards.size();
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	public Deck<E> shuffle(int[] shuffleArray) throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to shuffle an empty deck");
		} else if (shuffleArray == null || size() != shuffleArray.length) {
			throw new SimpleDecksException("Attempt to shuffle using null or invalid shuffle array");
		}
		final Card[] temp = cards.toArray(new Card[shuffleArray.length]);
		cards.clear();
		for(int i = 0; i < shuffleArray.length; i++) {
			cards.push((E) temp[shuffleArray[shuffleArray.length - 1 - i]]);
		}
		return this;
	}
	
}