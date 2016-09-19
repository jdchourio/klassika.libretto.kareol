package klassika.libretto.kareol.writer;

import java.util.ArrayList;

import klassika.libretto.kareol.bean.IOperaElement;
import klassika.libretto.kareol.bean.Libretto;
import klassika.libretto.kareol.bean.Character;
import klassika.libretto.kareol.bean.Stanza;

public class LibrettoMapper {
	public LibrettoDTO map(Libretto core) {
		LibrettoDTO bean = new LibrettoDTO();
		bean.setStanzas(new ArrayList<StanzaGroupDTO>());
		
		for (long coreIndex = 0, beanIndex = 1; coreIndex < core.getElements().size(); coreIndex++) {
			IOperaElement element = core.getElements().get((int) coreIndex);
			if (element instanceof Character && coreIndex + 1 < core.getElements().size()) {
				IOperaElement nextElement = core.getElements().get((int) (coreIndex + 1));
				if (nextElement instanceof Stanza) {
					map(bean, (Character)element, (Stanza) nextElement, beanIndex++);
				}
			}
		}
		return bean;
	}

	private void map(LibrettoDTO bean, Character element, Stanza stanza, long index) {
//		System.out.println("Mapping: " + element + " - " + stanza);
		StanzaDTO original = new StanzaDTO();
		original.setCharacter(element.getText().get(0));
		original.setLines(stanza.getText().get(0));

		StanzaDTO translation = new StanzaDTO();
		translation.setCharacter(element.getText().get(1));
		translation.setLines(stanza.getText().get(1));
		
		bean.addGroup(index, original, translation);
	}
}
