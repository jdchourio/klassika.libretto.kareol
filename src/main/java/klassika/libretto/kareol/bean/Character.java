package klassika.libretto.kareol.bean;


public class Character extends MultiLanguageElement implements IOperaElement {
	public String getName() {
		return text.get(0);
	}
	
	public void setName(String name) {
		this.text.set(name);
	}
	
	@Override
	public String toString() {
		return "Character: " + text.get(0) + " - " + text.get(1);
	}
}
