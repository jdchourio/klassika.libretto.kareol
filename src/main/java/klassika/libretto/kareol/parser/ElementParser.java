package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Segment;

public abstract class ElementParser implements IOperaElementParser {
	public IOperaElement parse(Segment segment) {
		if (segment instanceof Element) {
			return parse((Element)segment);
		}
		return null;
	}

	public boolean isValid(Segment segment) {
		if (segment instanceof Element) {
			return isValid((Element)segment);
		}
		return false;
	}

	protected abstract IOperaElement parse(Element segment);

	protected abstract boolean isValid(Element segment);
}
