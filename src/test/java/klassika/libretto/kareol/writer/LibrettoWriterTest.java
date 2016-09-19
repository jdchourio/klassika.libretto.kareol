package klassika.libretto.kareol.writer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LibrettoWriterTest {

	@Test
	public void testPrintJson() throws Exception {
		LibrettoDTO libretto = givenLibretto();
		
		new LibrettoWriter().printJson(libretto);
	}

	private LibrettoDTO givenLibretto() {
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("ITALIAN");
		languages.add("FRENCH");
		
		List<StanzaGroupDTO> stanzas = new ArrayList<StanzaGroupDTO>();

		StanzaDTO stanza1 = new StanzaDTO();
		stanza1.setCharacter("Faust");
		stanza1.setLines("Oh, mio amore!");
		
		StanzaDTO stanza2 = new StanzaDTO();
		stanza2.setCharacter("Faust");
		stanza2.setLines("Oh, mio amore!");
		
		LibrettoDTO libretto = new LibrettoDTO();
		libretto.setLanguages(languages);
		libretto.setStanzas(stanzas);
		libretto.addGroup(1, stanza1, stanza2);
		return libretto;
	}

}
