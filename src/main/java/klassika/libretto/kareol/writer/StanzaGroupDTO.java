package klassika.libretto.kareol.writer;

import java.io.Serializable;

public class StanzaGroupDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 338187902906279057L;

	private long line;
	private StanzaDTO original;
	private StanzaDTO translated;

	public long getLine() {
		return line;
	}

	public void setLine(long line) {
		this.line = line;
	}
	
	public StanzaDTO getOriginal() {
		return original;
	}

	public void setOriginal(StanzaDTO original) {
		this.original = original;
	}

	public StanzaDTO getTranslated() {
		return translated;
	}

	public void setTranslated(StanzaDTO translated) {
		this.translated = translated;
	}
}
