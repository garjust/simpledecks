package garjust.risk.cards;

import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards;

	public int deal() throws CardException {
		if (cards == null) {
			throw new CardException("Attempt to deal null deck");
		}
		return 0;
	}

}
