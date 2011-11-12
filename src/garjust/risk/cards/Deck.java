package garjust.risk.cards;

import garjust.risk.players.Player;
import garjust.risk.players.Players;

public class Deck extends Cards {

	public int dealDeck(Players players) throws CardException {
		if (noCards()) {
			throw new CardException("Attempt to deal an empty deck");
		}
		if (players == null || players.isEmpty()) {
			throw new CardException("Attempt to deal to null or empty list of players");
		}
		players.get(0);
		for (int i = 0; !cards.isEmpty(); i = (i + 1) % players.size()) {
			dealCard(players.get(i));
		}
		return 0;
	}
	
	public void dealCard(Player player) throws CardException {
		player.dealCard(popTopCard());
	}
	
	private Card popTopCard() throws CardException {
		if (noCards()) {
			throw new CardException("Attempt to deal a card from an empty deck");
		}
		Card card = cards.get(cards.size() - 1);
		cards.remove(card);
		return card;
	}

}
