package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.Character;
import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.MultiLanguageElement;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.StartTag;

public class CharacterParser implements IOperaElementParser {

	public IOperaElement parse(Segment segment) {
		if (isValid(segment)) {
			return read(segment.getChildElements().get(0));
		}
		return null;
	}
	
	private MultiLanguageElement read(Element element) {
		Character character = new Character();
		String name = element.getContent().toString().trim();
		character.setName(name);
		return character;
	}

	public boolean isValid(Segment segment) {
		if (segment instanceof StartTag) {
			StartTag startTag = ((StartTag)segment);
			String name = startTag.getName();
			return name.equals("strong");
		}
		return false;
	}
}
