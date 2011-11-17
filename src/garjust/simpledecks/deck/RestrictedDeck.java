package garjust.simpledecks.deck;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;

public interface RestrictedDeck<E extends Card> {

	public Deck<E> addCard(E card) throws SimpleDecksException;
	
	public E popCard() throws SimpleDecksException;

	public int size();

	public boolean isEmpty();

	public Deck<E> shuffle() throws SimpleDecksException;
}
