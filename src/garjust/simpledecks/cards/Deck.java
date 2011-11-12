package garjust.simpledecks.cards;

import java.util.LinkedList;

public class Deck implements Cards {
	
	private final LinkedList<Card> cards;
	
	public Deck() {
		this.cards = new LinkedList<Card>();
	}
	
	public Card popCard() throws CardException {
		if (isEmpty()) {
			throw new CardException("Attempt to deal a card from an empty deck");
		}
		return cards.pop();
	}
	
	@Override
	public Cards addCard(final Card card) {
		cards.push(card);
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
}
