package net.waglewagle.nos.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import junit.framework.TestCase;

public class InvalidCharacterReferenceBufferedReaderTest extends TestCase {
	public void test1() {
		String [] arr = {
				"A&#29;B",
				"A&x#29;B"
		};

		for (String str : arr) {
			StringReader sr = new StringReader(str);

			BufferedReader br = null;
			try {
				StripInvalidCharacterReferenceReader reader = new StripInvalidCharacterReferenceReader(sr);
				br = new BufferedReader(reader);

				System.out.println(br.readLine());
			}
			catch (IOException e) {
				fail(e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if ( br != null ) try { br.close(); } catch (Exception ignore) { }
			}
		}
	}


	public void test2() {
		InputStream is = getClass().getResourceAsStream("/invalid-char-refer.xml");

		BufferedReader br = null;
		try {
			StripInvalidCharacterReferenceReader reader = new StripInvalidCharacterReferenceReader(new InputStreamReader(is));
			br = new BufferedReader(reader);

			String line = null;
			while ( (line = br.readLine()) != null ) {
				System.out.println(line);
			}
		}
		catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if ( br != null ) try { br.close(); } catch (Exception ignore) { }
		}
	}
}
