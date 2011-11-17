package garjust.simpledecks.deck;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;

public interface Deck<E extends Card> extends RestrictedDeck<E> {
	
	public E pollCard(int i) throws SimpleDecksException;
	
	public E retrieveCard(int i) throws SimpleDecksException;
	
	public Deck<E> sort();
}