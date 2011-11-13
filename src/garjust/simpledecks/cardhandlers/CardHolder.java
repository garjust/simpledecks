package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Deck;
import garjust.simpledecks.cards.SimpleDeck;


public class CardHolder<E extends Card> {

	protected Deck<E> hand;
	
	public CardHolder() {
		this.hand = new SimpleDeck<E>();
	}

	public void recieveCard(E card) throws SimpleDecksException {
		if(card == null) {
			throw new SimpleDecksException("Attempt to receive null card");
		}
		hand.addCard(card);
	}

}
