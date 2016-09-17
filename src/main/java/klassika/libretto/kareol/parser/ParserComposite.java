package klassika.libretto.kareol.parser;

import java.util.ArrayList;
import java.util.List;

import klassika.libretto.kareol.bean.IOperaElement;
import net.htmlparser.jericho.Segment;

public class ParserComposite implements IOperaElementParser {
	private final List<IOperaElementParser> parsers;
	
	public ParserComposite() {
		parsers = new ArrayList<IOperaElementParser>();
		parsers.add(new CharacterParser());
		parsers.add(new IndicationParser());
		parsers.add(new StanzaParser());
		parsers.add(new DefaultParser());
	}

	public IOperaElement parse(Segment segment) {
		for (IOperaElementParser parser : this.parsers) {
			IOperaElement operaElement = parser.parse(segment);
			if (operaElement != null) {
				// debug(element, operaElement);
				return operaElement;
			}
		}
		return null;
	}

	public boolean isValid(Segment segment) {
		return true;
	}

}
