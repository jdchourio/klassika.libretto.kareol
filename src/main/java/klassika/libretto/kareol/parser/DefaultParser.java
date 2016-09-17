package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.UndefinedElement;
import net.htmlparser.jericho.Element;

public class DefaultParser extends ElementParser implements IOperaElementParser {

	public IOperaElement parse(Element segment) {
		UndefinedElement operaElement = new UndefinedElement();
		String name = segment.getContent().toString();
		operaElement.setText(name);
		return operaElement;
	}

	public boolean isValid(Element segment) {
		return true;
	}

}
