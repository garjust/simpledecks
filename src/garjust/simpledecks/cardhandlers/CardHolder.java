package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Hand;


public class CardHolder<E extends Card> {

	protected Hand<E> hand;
	
	public CardHolder() {
		this.hand = new Hand<E>();
	}

	public void recieveCard(Card card) {
		hand.addCard(card);
	}

}
