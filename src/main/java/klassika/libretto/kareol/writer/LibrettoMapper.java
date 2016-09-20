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
		StanzaDTO original = map(element, stanza, 0);
		StanzaDTO translation = map(element, stanza, 1);
		bean.addGroup(index, original, translation);
	}

	private StanzaDTO map(Character element, Stanza stanza, int languageIndex) {
		StanzaDTO original = new StanzaDTO();
		original.setCharacter(element.getText().get(languageIndex));
		original.setLines(stanza.getText().get(languageIndex));
		return original;
	}
}
