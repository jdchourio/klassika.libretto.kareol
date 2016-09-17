package klassika.libretto.kareol.bean;

public abstract class MultiLanguageElement implements IOperaElement {

	protected Text text = new Text();

	public Text getText() {
		return this.text;
	}

	public void addTranslation(int index, IOperaElement translatedLanguageElement) {
		if (translatedLanguageElement instanceof MultiLanguageElement) {
			MultiLanguageElement translated = (MultiLanguageElement)translatedLanguageElement;
			this.text.set(index, translated.text.get(0));
		} else {
			System.out.println("Problem adding " + translatedLanguageElement + " - to: " + this);
		}
	}
	
}
