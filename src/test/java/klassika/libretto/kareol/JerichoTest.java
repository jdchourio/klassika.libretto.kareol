package klassika.libretto.kareol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import klassika.libretto.kareol.parser.CharacterParser;
import net.htmlparser.jericho.JerichoUtil;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;

import org.junit.Test;

public class JerichoTest {

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

	@Test
	public void unboundElement() {
		Source s = new Source("<tr><p>12</p>34<p>Tonto</p>45</tr>");
		List<Segment> it = JerichoUtil.getTextNodes(s.getFirstElement());
		assertEquals(it.size(), 2);
	}

	@Test
	public void childIncludingTextNodes() {
		Source s = new Source("<tr><p>12</p>34<p>Tonto</p>45</tr>");
		List<Segment> it = JerichoUtil.getChildSegments(s.getFirstElement());
		assertEquals(it.size(), 4);
	}

}
