package klassika.libretto.kareol.writer;

import java.io.Serializable;
import java.util.List;

public class LibrettoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3076793652966355135L;
	
	private List<String> languages;
	private List<StanzaDTO> stanzas;

	public List<StanzaDTO> getStanzas() {
		return stanzas;
	}

	public void setStanzas(List<StanzaDTO> stanzas) {
		this.stanzas = stanzas;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
}
