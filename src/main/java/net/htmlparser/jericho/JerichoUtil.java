package net.htmlparser.jericho;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JerichoUtil {
	public static List<Segment> getTextNodes(Element elem) {

		final Iterator<Segment> it = elem.getContent().getNodeIterator();
	    final List<Segment> results = new LinkedList<Segment>();
	    final List<Element> children = elem.getChildElements();

	    while (it.hasNext()) {
	    	Segment cur = it.next();
	    	if (!(cur instanceof Tag) && !(cur instanceof CharacterReference) && !cur.isWhiteSpace()) {
	    		boolean enclosed = false;
	    		for (Element child : children) {
	    			if (child.encloses(cur)) { 
	    				enclosed = true;
	    			}
	    		}
	    		if (!enclosed) results.add(cur);
	    	}
	    }
	    return results;
	}
	
	public static List<Segment> getChildSegments(Element elem) {

		final Iterator<Segment> it = elem.getContent().getNodeIterator();
	    final List<Segment> results = new LinkedList<Segment>();
	    final List<Element> children = elem.getChildElements();

	    while (it.hasNext()) {
	    	Segment cur = it.next();
	    	if (!(cur instanceof Tag) && !(cur instanceof CharacterReference) && !cur.isWhiteSpace()) {
	    		boolean enclosed = false;
	    		for (Element child : children) {
	    			if (child.encloses(cur)) { 
	    				enclosed = true;
	    			}
	    		}
	    		if (!enclosed) results.add(cur);
	    	} else {
	    		for (Element child : children) {
	    			if (child.getStartTag().equals(cur)) {
	    				results.add(cur);
	    				break;
	    			}
	    		}
	    	}
	    }
	    return results;
	}

	public static List<Segment> getChildSegments(List<Element> elements) {
		List<Segment> toReturn = new ArrayList<Segment>();
		for (Element source : elements) {
			List<Segment> children = getChildSegments(source);
			toReturn.addAll(children);
		}
		return toReturn;
	}
	

}
