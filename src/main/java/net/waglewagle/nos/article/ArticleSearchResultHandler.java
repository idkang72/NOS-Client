package net.waglewagle.nos.article;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import net.waglewagle.nos.INdslArticle;
import net.waglewagle.nos.NosException;
import net.waglewagle.nos.QueryResult;
import net.waglewagle.nos.http.BaseResponseHandler;

/**
 * <p>논문 검색 결과 처리 핸들러.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class ArticleSearchResultHandler extends BaseResponseHandler<QueryResult<ArticleInputData, INdslArticle>> {
	private final static Logger log = Logger.getLogger(ArticleSearchResultHandler.class.getName());

	public QueryResult<ArticleInputData, INdslArticle> handle(InputStream is, String encoding) throws IOException {
		ArticleSearchResultXmlHandler handler = new ArticleSearchResultXmlHandler();

		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParser parser;
		try {
			parser = factory.newSAXParser();

			parser.parse(is, handler);
		}
		catch (ParserConfigurationException e) {
			throw new NosException(e);
		}
		catch (SAXException e) {
			throw new NosException(e);
		}


		QueryResult<ArticleInputData, INdslArticle> result = handler.getQueryResult();

		log.log(Level.FINEST, "Count: {0}", result.getCount());

		return handler.getQueryResult();
	}
}
