package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.Character;
import klassika.libretto.kareol.bean.IOperaElement;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.StartTag;

public class CharacterParser implements IOperaElementParser {

	/* (non-Javadoc)
	 * @see klassika.libretto.kareol.IOperaElementParser#parse(net.htmlparser.jericho.Element)
	 */
	public IOperaElement parse(Element element) {
		if (isValid(element)) {
			return read(element);
		}
		return null;
	}
	
	private Character read(Element element) {
		Character character = new Character();
		String name = element.getContent().toString().trim();
		character.setName(name);
		return character;
	}

	/* (non-Javadoc)
	 * @see klassika.libretto.kareol.IOperaElementParser#isValid(net.htmlparser.jericho.Element)
	 */
	public boolean isValid(Element element) {
		StartTag startTag = element.getStartTag();
		String name = startTag.getName();
		return name.equals("strong");
	}
}
