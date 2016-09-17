package klassika.libretto.kareol;

import klassika.libretto.kareol.parser.FileParser;

public class Application {
	public static void main(String[] args) throws Exception {
		String inputFilename = args[0];
		
		new FileParser().parseSingleLanguageStanzas(inputFilename);
	}

}
