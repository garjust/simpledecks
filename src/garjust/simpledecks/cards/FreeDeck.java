package garjust.simpledecks.cards;

import java.util.Collection;

public interface FreeDeck<E extends Card> extends Deck<E> {
	
	public Collection<E> cards();
}
