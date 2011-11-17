package garjust.simpledecks.deck;

import garjust.simpledecks.card.Card;

import java.util.Collection;

public interface FreeDeck<E extends Card> extends Deck<E> {
	
	public Collection<E> cards();
}
