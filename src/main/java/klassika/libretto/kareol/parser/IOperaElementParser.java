package klassika.libretto.kareol.parser;

import klassika.libretto.kareol.bean.IOperaElement;
import net.htmlparser.jericho.Segment;

public interface IOperaElementParser {

	public abstract IOperaElement parse(Segment segment);

	public abstract boolean isValid(Segment segment);

}