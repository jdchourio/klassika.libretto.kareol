package klassika.libretto.kareol.bean;

public class Stanza implements IOperaElement {
	private String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Stanza: " + getText();
	}
}
