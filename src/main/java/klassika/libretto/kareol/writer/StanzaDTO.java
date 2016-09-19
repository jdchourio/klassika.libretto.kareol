package klassika.libretto.kareol.writer;

import java.io.Serializable;

public class StanzaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3400266061113357105L;
	
	private StanzaMetaDTO metadata = new StanzaMetaDTO();

	private String character;
	private String lines;
	
	public String getCharacter() {
		return character;
	}
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	public String getLines() {
		return lines;
	}
	
	public void setLines(String lines) {
		this.lines = lines;
	}

	public StanzaMetaDTO getMetadata() {
		return metadata;
	}

	public void setMetadata(StanzaMetaDTO metaData) {
		this.metadata = metaData;
	}

}
