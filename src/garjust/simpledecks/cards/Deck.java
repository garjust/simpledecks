package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

public interface Deck<E extends Card> extends RestrictedDeck<E> {
	
	public E pollCard(int i) throws SimpleDecksException;
	
	public E retrieveCard(int i) throws SimpleDecksException;
}