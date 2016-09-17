package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.Indication;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.StartTag;

public class IndicationParser implements IOperaElementParser {
	public Indication parse(Segment segment) {
		if (isValid(segment)) {
			return read(segment);
		}
		return null;
	}
	
	private Indication read(Segment segment) {
		Indication operaElement = new Indication();
		String name = segment.getChildElements().get(0).getContent().toString();
		operaElement.setText(name);
		return operaElement;
	}

	public boolean isValid(Segment segment) {
		if (segment instanceof StartTag) {
			StartTag startTag = (StartTag)segment;
			String name = startTag.getName();
			return name.equals("em");
		}
		return false;
	}

}
