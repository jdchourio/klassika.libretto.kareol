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
		LibrettoDTO libretto = new LibrettoDTO();
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("ITALIAN");
		languages.add("FRENCH");
		libretto.setLanguages(languages);
		List<StanzaDTO> stanzas = new ArrayList<StanzaDTO>();
		StanzaDTO stanza1 = new StanzaDTO();
		StanzaMetaDTO metadata = new StanzaMetaDTO();
		metadata.setLanguage("ITALIAN");
		stanza1.setMetadata(metadata);
		stanza1.setCharacter("Faust");
		stanza1.setLines("Oh, mio amore!");
		stanzas.add(stanza1);
		libretto.setStanzas(stanzas);
		return libretto;
	}

}
