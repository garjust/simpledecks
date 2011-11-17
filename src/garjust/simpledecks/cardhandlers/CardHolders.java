package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.card.Card;

import java.util.ArrayList;

public class CardHolders<E extends Card> {

	private ArrayList<CardHolder<E>> cardHolders;
	
	public CardHolders() {
		this.cardHolders = new ArrayList<CardHolder<E>>();
	}

	public void addCardHolder(CardHolder<E> player) {
		cardHolders.add(player);
	}

	public int countCardHolders() {
		return cardHolders.size();
	}

	public CardHolder<E> removeCardHolder(CardHolder<E> cardHolder) throws SimpleDecksException {
		if (!cardHolders.remove(cardHolder)) {
			throw new SimpleDecksException("Attempted to remove non existing card holder from card holder list");
		}
		return cardHolder;
	}

}
