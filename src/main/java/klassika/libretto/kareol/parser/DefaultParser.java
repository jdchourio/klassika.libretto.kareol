package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.UndefinedElement;
import net.htmlparser.jericho.Element;

public class DefaultParser implements IOperaElementParser {

	public IOperaElement parse(Element element) {
		UndefinedElement operaElement = new UndefinedElement();
		String name = element.getContent().toString();
		operaElement.setText(name);
		return operaElement;
	}

	public boolean isValid(Element element) {
		return true;
	}

}
