package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import net.htmlparser.jericho.Element;

public interface IOperaElementParser {

	public abstract IOperaElement parse(Element element);

	public abstract boolean isValid(Element element);

}