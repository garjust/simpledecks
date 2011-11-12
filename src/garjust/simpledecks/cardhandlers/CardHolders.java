package garjust.simpledecks.cardhandlers;

import garjust.simpledecks.cards.Card;

import java.util.ArrayList;

public class CardHolders<E extends Card> {

	private ArrayList<CardHolder<E>> cardHolders;
	
	public CardHolders() {
		cardHolders = new ArrayList<CardHolder<E>>();
	}

}
