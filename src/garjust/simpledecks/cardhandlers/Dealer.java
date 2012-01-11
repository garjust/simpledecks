package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;
import garjust.simpledecks.deck.RestrictedDeck;

public class Dealer<E extends Card> {

	private final RestrictedDeck<E> deck;
	private final CardHolderList<E> cardHolders;

	public Dealer(RestrictedDeck<E> deck, CardHolderList<E> cardHolders) {
		this.deck = deck;
		this.cardHolders = cardHolders;
	}

	public void deal() {
		try {
			for(int i = 0; !deck.isEmpty(); i = (i + 1) % cardHolders.size()) {
				cardHolders.get(i).recieveCard(deck.popCard());
			}
		} catch (SimpleDecksException e) {
			System.err.println("Failed to deal");
		}
	}

}
