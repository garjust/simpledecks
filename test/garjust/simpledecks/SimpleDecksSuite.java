package garjust.simpledecks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	garjust.simpledecks.cardhandlers.CardHandlersSuite.class,
    garjust.simpledecks.cards.CardsSuite.class
})
public class SimpleDecksSuite {

}
