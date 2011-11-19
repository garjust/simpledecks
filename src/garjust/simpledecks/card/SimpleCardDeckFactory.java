package garjust.simpledecks.card;

import garjust.simpledecks.SimpleDecksException;
import garjust.simpledecks.deck.FreeDeck;
import garjust.simpledecks.deck.SimpleDeck;

public class SimpleCardDeckFactory {
	
	public static final int[] BLACKJACK_VALUES = {
		2,3,4,5,6,7,8,9,10,10,10,10,1
	};

	public SimpleCardDeckFactory() {
	}
	
	public FreeDeck<SimpleCard> build(final SimpleCardDeckType type) throws SimpleDecksException {
		return build(type, new SimpleDeck<SimpleCard>());
	}
	
	public FreeDeck<SimpleCard> build(final SimpleCardDeckType type, final FreeDeck<SimpleCard> deck) throws SimpleDecksException {
		if (deck == null) {
			throw new SimpleDecksException("Attempt to add SimpleCards to null deck");
		}
		deck.cards().clear();
		try {
			switch (type) {
				case SIMPLE:
					buildSimple(deck);
					break;
				case BLACKJACK:
					buildBlackjack(deck);
					break;
			}
		} catch (SimpleDecksException e) {
			System.err.println("ERROR: Failed to build deck of type " + type + ". Returning empty deck");
			return new SimpleDeck<SimpleCard>();
		}
		deck.sort();
		return deck;
	}
	
	private void buildDeckFiftyTwo(final FreeDeck<SimpleCard> deck, final int[] values) throws SimpleDecksException {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (int suitIndex = 0; suitIndex < suits.length; suitIndex++) {
			for (int rankIndex = 0; rankIndex < ranks.length; rankIndex++) {
				if (values == null) {
					deck.addCard(new SimpleCard(suits[suitIndex], ranks[rankIndex]));
				} else {
					deck.addCard(new SimpleCard(values[rankIndex], suits[suitIndex], ranks[rankIndex]));
				}
			}
		}
	}
	
	private void buildSimple(final FreeDeck<SimpleCard> deck) throws SimpleDecksException {
		buildDeckFiftyTwo(deck, null);
	}
	
	private void buildBlackjack(final FreeDeck<SimpleCard> deck) throws SimpleDecksException {
		buildDeckFiftyTwo(deck, BLACKJACK_VALUES);
	}
	
	public enum SimpleCardDeckType {
		SIMPLE,
		BLACKJACK
	}
}
