package garjust.simpledecks.card;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	garjust.simpledecks.card.CardTest.class,
    garjust.simpledecks.card.SimpleCardTest.class,
    garjust.simpledecks.card.SimpleCardDeckFactoryTest.class
})
public class CardTestSuite {

}

