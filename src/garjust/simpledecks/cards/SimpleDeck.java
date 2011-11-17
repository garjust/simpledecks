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
		} else if (cards.contains(card)) {
			throw new SimpleDecksException("Attempt to add duplicate card to deck");
		}
		cards.add((int)(Math.random() * size()), card);
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
	public Deck<E> order(int[] orderArray) throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to order an empty deck");
		} else if (orderArray == null) {
			throw new SimpleDecksException("Attempt to order using null shuffle array");
		} else if (size() != orderArray.length) {
			throw new SimpleDecksException("Attempt to order using invalid shuffle array (decksize="+size()+", arraysize="+orderArray.length+")");
		}
		final Card[] temp = cards.toArray(new Card[orderArray.length]);
		cards.clear();
		for(int i = 0; i < orderArray.length; i++) {
			cards.add((E) temp[orderArray[i]]);
		}
		return this;
	}
	
}