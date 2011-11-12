package garjust.simpledecks.cards;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	garjust.simpledecks.cards.types.TypesSuite.class,
    garjust.simpledecks.cards.DeckTest.class,
    garjust.simpledecks.cards.HandTest.class
})
public class CardsSuite {

}
