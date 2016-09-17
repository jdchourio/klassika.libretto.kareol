package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Stanza;
import net.htmlparser.jericho.Segment;

public class StanzaParser implements IOperaElementParser {

	public IOperaElement parse(Segment segment) {
		Stanza stanza = new Stanza();
		stanza.setText(segment.toString());
		return stanza;
	}

	public boolean isValid(Segment segment) {
		return true;
	}

}
