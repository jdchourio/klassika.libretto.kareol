package klassika.libretto.kareol.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Libretto;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.JerichoUtil;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;

public class FileParser {
	private static final int ORIGINAL_LANGUAGE_INDEX = 0;
	private static final int TRANSLATED_LANGUAGE_INDEX = 1;
	private final ParserComposite parserComposite;

	public FileParser() {
		parserComposite = new ParserComposite();
	}

	public Libretto parseSingleLanguageStanzas(String inputFilename) throws FileNotFoundException, IOException {
		Element source = new Source(new FileReader(inputFilename)).getFirstElement();
		List<Element> originalLanguageSource = extractMultipleSingleLanguageElements(source, ORIGINAL_LANGUAGE_INDEX);
		Element translatedLanguageSource = extractSingleLanguageElements(source, TRANSLATED_LANGUAGE_INDEX);
		
		List<Segment> textNodes = JerichoUtil.getChildSegments(originalLanguageSource);
		List<IOperaElement> originalLanguageElements = parse(textNodes);

		Libretto libretto = new Libretto();
		for (IOperaElement operaElement : originalLanguageElements) {
			libretto.addElement(operaElement);
		}
		return libretto;
	}

	private List<IOperaElement> parse(List<Segment> textNodes) {
		List<IOperaElement> elements = new ArrayList<IOperaElement>();
		for (Segment element : textNodes) {
			IOperaElement operaElement = parserComposite.parse(element);
			elements.add(operaElement);
		}
		return elements;
	}
	
	private Element extractSingleLanguageElements(Element source, int languageIndex) {
		List<Element> tables = source.getAllElements("table");
		Element languageTable = tables.get(1);
		List<Element> columns = languageTable.getAllElements("td");
		return columns.get(languageIndex).getAllElements("font").get(1);
	}

	private List<Element> extractMultipleSingleLanguageElements(Element source, int languageIndex) {
		List<Element> elements = new ArrayList<Element>();
		List<Element> tables = source.getAllElements("table");
		Element languageTable = tables.get(1);
		List<Element> columns = languageTable.getAllElements("td");
		for (int index = languageIndex; index < columns.size(); index += 2) {
			elements.addAll(columns.get(index).getAllElements("font"));
		}
		return elements;
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
