package garjust.simpledecks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	garjust.simpledecks.cardhandlers.CardHandlersTestsSuite.class,
    garjust.simpledecks.cards.CardsTestSuite.class
})
public class SimpleDecksTestSuite {

}
