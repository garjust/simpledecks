package garjust.simpledecks.players;

import garjust.simpledecks.cards.Card;
import garjust.simpledecks.cards.Hand;


public class CardHolder {

	protected Hand hand;
	
	public CardHolder() {
		this.hand = new Hand();
	}

	public void recieveCard(Card card) {
		hand.addCard(card);
	}

}
