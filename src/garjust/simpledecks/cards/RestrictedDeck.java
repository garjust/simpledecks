package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

public interface RestrictedDeck<E extends Card> {

	public Deck<E> addCard(E card) throws SimpleDecksException;
	
	public E popCard() throws SimpleDecksException;

	public int size();

	public boolean isEmpty();

	public Deck<E> shuffle(int[] shuffleArray) throws SimpleDecksException;
}
