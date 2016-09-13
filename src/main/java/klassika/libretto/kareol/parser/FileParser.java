package klassika.libretto.kareol.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Libretto;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class FileParser {
	private final List<IOperaElementParser> parsers;

	public FileParser() {
		parsers = new ArrayList<IOperaElementParser>();
		parsers.add(new CharacterParser());
		parsers.add(new IndicationParser());
		parsers.add(new DefaultParser());
	}

	public void parse(String inputFilename) throws IOException,
			FileNotFoundException {
		Source source = new Source(new FileReader(inputFilename));
		List<Element> elementList = source.getAllElements();

		Libretto libretto = new Libretto();
		for (Element element : elementList) {
			IOperaElement operaElement = parse(element);
			libretto.addElement(operaElement);
//			System.out.println(operaElement);
		}
		for (IOperaElement operaElement : libretto.getUndefinedElements()) {
			System.out.println(operaElement);
		}
	}

	private IOperaElement parse(Element element) {
		for (IOperaElementParser parser : this.parsers) {
			IOperaElement operaElement = parser.parse(element);
			if (operaElement != null) {
				// debug(element, operaElement);
				return operaElement;
			}
		}
		return null;
	}

//	private void debug(Element element, IOperaElement operaElement) {
//		System.out
//				.println("-------------------------------------------------------------------------------");
//		System.out.println(element.getDebugInfo());
//		if (element.getAttributes() != null)
//			System.out.println("XHTML StartTag:\n"
//					+ element.getStartTag().tidy(true));
//		System.out.println("Source text with content:\n" + element);
//		System.out.println(operaElement);
//	}

}
