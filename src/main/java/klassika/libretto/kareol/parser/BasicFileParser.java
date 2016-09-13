package klassika.libretto.kareol.parser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import net.htmlparser.jericho.CharacterReference;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.Tag;

public class BasicFileParser {
	private static final int LANGUAGE_SPANISH = 1;

	public void parse(String inputFilename) throws Exception {
		Source source=new Source(new FileReader(inputFilename));
		Element characters = getCharacters(source);
		Element tableWithLibretto = getLibretto(source);
		Element parent = getLibrettoInLanguage(tableWithLibretto, LANGUAGE_SPANISH);
		int segmentCounter = 0;
		for (Iterator<Segment> nodeIterator=parent.getNodeIterator(); nodeIterator.hasNext();) {
			   Segment nodeSegment = nodeIterator.next();
			   System.out.println("Counter: " + segmentCounter++);
			   if (nodeSegment instanceof Tag) {
			     Tag tag = (Tag)nodeSegment;
			     System.out.println("Tag: " + tag.getName());
			   } else if (nodeSegment instanceof CharacterReference) {
			     CharacterReference characterReference=(CharacterReference)nodeSegment;
			     // HANDLE CHARACTER REFERENCE
			     // Uncomment the following line to decode all character references instead of copying them verbatim:
			     // characterReference.appendCharTo(writer); continue;
			   } else {
				     System.out.println("Plain text: " + nodeSegment);
			     // HANDLE PLAIN TEXT
			   }
			 }

	}

	private Element getLibrettoInLanguage(Element tableWithLibretto, int languageId) {
		Element parent = tableWithLibretto.getAllElements("font").get(languageId);
		return parent;
	}

	private Element getCharacters(Source source) {
		List<Element> tables = source.getAllElements("table");
		Element tableWithLibretto = tables.get(0);
		return tableWithLibretto;
	}

	private Element getLibretto(Source source) {
		List<Element> tables = source.getAllElements("table");
		Element tableWithLibretto = tables.get(1);
		return tableWithLibretto;
	}
	

}
