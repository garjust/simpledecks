package garjust.simpledecks.cards;

public abstract class Cards<E extends Card> {

	public abstract Cards<E> addCard(E card);
	
	public abstract int countCards();
	
	public abstract boolean isEmpty();
}