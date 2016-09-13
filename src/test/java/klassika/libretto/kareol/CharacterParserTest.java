package klassika.libretto.kareol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import klassika.libretto.kareol.parser.CharacterParser;
import net.htmlparser.jericho.Source;

import org.junit.Test;

public class CharacterParserTest {

	@Test
	public void test() {
		Source s = new Source("<strong></strong>");
		boolean valid = new CharacterParser().isValid(s.getFirstElement());
		assertTrue(valid);
	}

	@Test
	public void invalidCharacter() {
		Source s = new Source("<p></p>");
		boolean valid = new CharacterParser().isValid(s.getFirstElement());
		assertFalse(valid);
	}

}
