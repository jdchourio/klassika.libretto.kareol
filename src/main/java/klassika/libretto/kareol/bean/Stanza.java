package klassika.libretto.kareol.bean;

public class Stanza extends MultiLanguageElement implements IOperaElement {
	public void setContent(String text) {
		this.text.set(text);
	}
	
	@Override
	public String toString() {
		return "Stanza: " + text.get(0) + " - " + text.get(1);
	}
}
