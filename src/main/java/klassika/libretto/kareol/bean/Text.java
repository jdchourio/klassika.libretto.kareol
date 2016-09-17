package klassika.libretto.kareol.bean;

import java.util.HashMap;
import java.util.Map;

public class Text {
	private static final int ORIGINAL_LANGUAGE_INDEX = 0;

	private Map<Integer, String> texts = new HashMap<Integer, String>();
	
	public String toString() {
		return texts.get(ORIGINAL_LANGUAGE_INDEX);
	}

	public String get(int index) {
		return this.texts.get(index);
	}
	
	public void set(String text) {
		set(ORIGINAL_LANGUAGE_INDEX, text);
	}

	public void set(int index, String text) {
		texts.put(index, text);
	}
}
