package klassika.libretto.kareol.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Libretto;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class ElementFileParser {
	private final ParserComposite parserComposite = new ParserComposite();
	
	public void parse(String inputFilename) throws IOException,
			FileNotFoundException {
		Source source = new Source(new FileReader(inputFilename));
		List<Element> elementList = source.getAllElements();

		Libretto libretto = new Libretto();
		for (Element element : elementList) {
			IOperaElement operaElement = parserComposite.parse(element);
			libretto.addElement(operaElement);
			// System.out.println(operaElement);
		}
		for (IOperaElement operaElement : libretto.getUndefinedElements()) {
			System.out.println(operaElement);
		}
	}

}
