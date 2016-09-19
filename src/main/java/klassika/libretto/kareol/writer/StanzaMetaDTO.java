package klassika.libretto.kareol.writer;

import java.io.Serializable;

public class StanzaMetaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3238377960679986917L;
	
	private String language;

	public StanzaMetaDTO() {
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}