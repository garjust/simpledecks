package garjust.simpledecks.cards;

import garjust.simpledecks.SimpleDecksException;

import java.util.ArrayList;

public class Hand<E extends Card> extends Cards<E> {
	
	private final ArrayList<E> cards;
	
	public Hand() {
		cards = new ArrayList<E>();
	}
	
	@Override
	public Cards<E> addCard(E card) throws SimpleDecksException {
		if (card == null) {
			throw new SimpleDecksException("Attempt to add null card to hand");
		}
		cards.add(card);
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
	protected void shuffleCards(int[] shuffleArray) {
		// TODO Auto-generated method stub
		
	}

	public E card(int i) {
		return cards.get(i);
	}
}
