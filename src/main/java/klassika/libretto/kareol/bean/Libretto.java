package klassika.libretto.kareol.bean;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<IOperaElement> elements = new ArrayList<IOperaElement>();
	
	private List<IOperaElement> undefinedElements = new ArrayList<IOperaElement>();

	public List<IOperaElement> getElements() {
		return elements;
	}

	public void setElements(List<IOperaElement> elements) {
		this.elements = elements;
	}

	public void addElement(IOperaElement element) {
		this.elements.add(element);
		if (element instanceof UndefinedElement) {
			this.addUndefinedElement(element);
		}
	}
	
	void addUndefinedElement(IOperaElement element) {
		this.undefinedElements.add(element);
	}
	
	public List<IOperaElement> getUndefinedElements() {
		return undefinedElements;
	}

}
