package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

public abstract class Cards<E extends Card> {

	public abstract Cards<E> addCard(E card) throws SimpleDecksException;
	
	public abstract int countCards();
	
	public abstract boolean isEmpty();
	
	public abstract Cards<E> shuffle(int[] shuffleArray) throws SimpleDecksException;
}