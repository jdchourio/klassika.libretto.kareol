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
		List<StanzaGroupDTO> stanzas = new ArrayList<StanzaGroupDTO>();
		StanzaGroupDTO group1 = new StanzaGroupDTO();
		StanzaDTO stanza1 = new StanzaDTO();
		StanzaMetaDTO metadata = new StanzaMetaDTO();
		metadata.setLanguage("ITALIAN");
		stanza1.setMetadata(metadata);
		stanza1.setCharacter("Faust");
		stanza1.setLines("Oh, mio amore!");
		StanzaDTO stanza2 = new StanzaDTO();
		StanzaMetaDTO metadata2 = new StanzaMetaDTO();
		metadata2.setLanguage("ITALIAN");
		stanza2.setMetadata(metadata2);
		stanza2.setCharacter("Faust");
		stanza2.setLines("Oh, mio amore!");
		group1.setOriginal(stanza1);
		group1.setTranslated(stanza2);
		stanzas.add(group1);
		libretto.setStanzas(stanzas);
		return libretto;
	}

}
