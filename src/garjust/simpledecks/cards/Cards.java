package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

public abstract class Cards<E extends Card> {
	
	public abstract Cards<E> addCard(E card) throws SimpleDecksException;
	
	public abstract int countCards();
	
	public abstract boolean isEmpty();
	
	protected abstract void shuffleCards(final int[] shuffleArray);
	
	public Cards<E> shuffle(int[] shuffleArray) throws SimpleDecksException {
		if (isEmpty()) {
			throw new SimpleDecksException("Attempt to shuffle an empty deck");
		} else if (shuffleArray == null || countCards() != shuffleArray.length) {
			throw new SimpleDecksException("Attempt to shuffle using null or invalid shuffle array");
		}
		shuffleCards(shuffleArray);
		return this;
	}
	
}