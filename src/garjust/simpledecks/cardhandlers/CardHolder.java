package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;
import garjust.simpledecks.deck.FreeDeck;
import garjust.simpledecks.deck.SimpleDeck;


public class CardHolder<E extends Card> {

	protected FreeDeck<E> hand;
	
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
