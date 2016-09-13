package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.Indication;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.StartTag;

public class IndicationParser implements IOperaElementParser {
	public Indication parse(Element element) {
		if (isValid(element)) {
			return read(element);
		}
		return null;
	}
	
	private Indication read(Element element) {
		Indication operaElement = new Indication();
		String name = element.getContent().toString();
		operaElement.setText(name);
		return operaElement;
	}

	public boolean isValid(Element element) {
		StartTag startTag = element.getStartTag();
		String name = startTag.getName();
		return name.equals("em");
	}

}
