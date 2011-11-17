package garjust.simpledecks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	garjust.simpledecks.card.CardTestSuite.class,
	garjust.simpledecks.cardhandlers.CardHandlersTestsSuite.class,
    garjust.simpledecks.deck.DeckTestSuite.class
})
public class SimpleDecksTestSuite {

}
