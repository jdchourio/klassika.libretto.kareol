package klassika.libretto.kareol.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Libretto;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.JerichoUtil;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;

public class FileParser {
	private final ParserComposite parserComposite;

	public FileParser() {
		parserComposite = new ParserComposite();
	}

	public void parse(String inputFilename) throws IOException,
			FileNotFoundException {
		Source source = new Source(new FileReader(inputFilename));
		List<Element> elementList = source.getAllElements();

		Libretto libretto = new Libretto();
		for (Element element : elementList) {
			IOperaElement operaElement = parserComposite.parse(element);
			libretto.addElement(operaElement);
//			System.out.println(operaElement);
		}
		for (IOperaElement operaElement : libretto.getUndefinedElements()) {
			System.out.println(operaElement);
		}
	}
	
	public void parseSingleLanguageStanzas(String inputFilename) throws FileNotFoundException, IOException {
		Source source = new Source(new FileReader(inputFilename));
		Element singleLanguageSource = extractSingleLanguageElements(source.getFirstElement());
		List<Segment> textNodes = JerichoUtil.getChildSegments(singleLanguageSource);
		System.out.println("Number of segments: " + textNodes.size());
		Libretto libretto = new Libretto();
		for (Segment element : textNodes) {
			IOperaElement operaElement = parserComposite.parse(element);
			libretto.addElement(operaElement);
//			System.out.println(operaElement);
		}
		System.out.println("Number of elements: " + libretto.getElements().size());
		for (IOperaElement operaElement : libretto.getElements()) {
			System.out.println(operaElement);
		}
	}

	private Element extractSingleLanguageElements(Element source) {
		List<Element> tables = source.getAllElements("table");
		Element languageTable = tables.get(1);
		return languageTable.getAllElements("td").get(0).getAllElements("font").get(1);
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
