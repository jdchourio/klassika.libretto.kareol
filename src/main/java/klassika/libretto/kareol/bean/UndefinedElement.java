package klassika.libretto.kareol.bean;


public class UndefinedElement implements IOperaElement {
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Undefined element: " + text;
	}

	public void addTranslation(int index, IOperaElement translatedLanguageElement) {
		// TODO Auto-generated method stub
		
	}

}
