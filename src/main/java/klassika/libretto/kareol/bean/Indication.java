package klassika.libretto.kareol.bean;


public class Indication implements IOperaElement {
	private String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Indication: " + getText();
	}
}
