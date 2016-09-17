package klassika.libretto.kareol.bean;


public class Indication extends MultiLanguageElement implements IOperaElement {
	public void setContent(String text) {
		this.text.set(text);
	}
	
	@Override
	public String toString() {
		return "Indication: " + text.get(0) + " - " + text.get(1);
	}
}
