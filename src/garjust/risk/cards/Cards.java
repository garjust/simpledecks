package garjust.risk.cards;

import java.util.ArrayList;

public class Cards {

	protected ArrayList<Card> cards;

	public Cards() {
		cards = new ArrayList<Card>();
	}

	public Cards addCard(Card card) {
		cards.add(card);
		return this;
	}

	public boolean noCards() {
		return cards.isEmpty();
	}

}