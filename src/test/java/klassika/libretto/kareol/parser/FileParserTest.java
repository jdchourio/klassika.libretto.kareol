package klassika.libretto.kareol.parser;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import klassika.libretto.kareol.bean.Libretto;

import org.junit.Test;

public class FileParserTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		Libretto libretto = new FileParser()
			.parseSingleLanguageStanzas("/Users/jdiazch/Documents/workspace/klassika.libretto.kareol/src/test/resources/Kareol.es.html");
		assertEquals(libretto.getElements().size(), 241);
	}

	@Test
	public void testParsifal() throws FileNotFoundException, IOException {
		Libretto libretto = new FileParser()
			.parseSingleLanguageStanzas("/Users/jdiazch/Documents/workspace/klassika.libretto.kareol/src/test/resources/parsifal.1.html");
		assertEquals(592, libretto.getElements().size());
		assertEquals(133, libretto.getCharacters().size());
	}

	@Test
	public void testFaust() throws FileNotFoundException, IOException {
		Libretto libretto = new FileParser()
			.parseSingleLanguageStanzas("/Users/jdiazch/Documents/workspace/klassika.libretto.kareol/src/test/resources/faust.1.html");
		assertEquals(125, libretto.getElements().size());
		assertEquals(44, libretto.getCharacters().size());
		libretto.print();
	}

}
