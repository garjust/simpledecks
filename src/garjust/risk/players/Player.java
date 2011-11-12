package garjust.risk.players;

import garjust.risk.cards.Card;
import garjust.risk.cards.Hand;


public class Player {

	private Hand hand;
	
	public Player() {
		this.hand = new Hand();
	}

	public void dealCard(Card card) {
		hand.addCard(card);
	}

}
