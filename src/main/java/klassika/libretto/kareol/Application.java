package klassika.libretto.kareol;

import klassika.libretto.kareol.bean.Libretto;
import klassika.libretto.kareol.parser.FileParser;
import klassika.libretto.kareol.writer.LibrettoDTO;
import klassika.libretto.kareol.writer.LibrettoMapper;
import klassika.libretto.kareol.writer.LibrettoWriter;

public class Application {
	public static void main(String[] args) throws Exception {
		String inputFilename = args[0];
		
		Libretto libretto = new FileParser().parseMultiLanguageStanzas(inputFilename);
		LibrettoDTO bean = new LibrettoMapper().map(libretto);
		
		new LibrettoWriter().printJson(bean);
	}

}
