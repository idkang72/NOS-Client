package net.waglewagle.nos.article;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import junit.framework.TestCase;
import net.waglewagle.nos.INdslArticle;
import net.waglewagle.nos.QueryResult;
import net.waglewagle.nos.xml.StripInvalidCharacterReferenceReader;

public class ArticleSearchResultXmlHandlerTest extends TestCase {
	public void test1() {
		ArticleSearchResultXmlHandler handler = new ArticleSearchResultXmlHandler();

		InputStream is = getClass().getResourceAsStream("/ndsl-result.xml");

		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			SAXParser parser = factory.newSAXParser();

			parser.parse(is, handler);

			QueryResult<ArticleInputData, INdslArticle> result = handler.getQueryResult();

			System.out.println("Count: " + result.getCount());

			for (INdslArticle article : handler.getQueryResult()) {
				System.out.printf("%s%n    in %s%n", article.getTitle(), article.getJournal().getTitle());
			}

			assertNotNull(handler.getQueryResult());

		}
		catch (ParserConfigurationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (SAXException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}


	public void testForError() {
		ArticleSearchResultXmlHandler handler = new ArticleSearchResultXmlHandler();

		InputStream is = getClass().getResourceAsStream("/ndsl-error.xml");

		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			SAXParser parser = factory.newSAXParser();

			parser.parse(is, handler);


			QueryResult<ArticleInputData, INdslArticle> result = handler.getQueryResult();

			System.out.println("Count: " + result.getCount());

			fail("여기가 실행되면 안  된다");
		}
		catch (ParserConfigurationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (SAXException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			assertTrue(e.getMessage(), true);
		}
	}


	public void testInvalidCharRefer() {
		ArticleSearchResultXmlHandler handler = new ArticleSearchResultXmlHandler();

		InputStream is = getClass().getResourceAsStream("/invalid-char-refer.xml");

		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {

			StripInvalidCharacterReferenceReader reader = new StripInvalidCharacterReferenceReader(new InputStreamReader(is));

			InputSource source = new InputSource(reader);

			SAXParser parser = factory.newSAXParser();
			parser.parse(source, handler);

			QueryResult<ArticleInputData, INdslArticle> result = handler.getQueryResult();

			System.out.println("Count: " + result.getCount());

			assertTrue(true);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
