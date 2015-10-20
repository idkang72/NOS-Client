package net.waglewagle.nos.article;

import junit.framework.TestCase;
import net.waglewagle.nos.QueryResult;

public class ArticleSearcherTest extends TestCase {
	private final static String baseUrl = "http://openapi.ndsl.kr/itemsearch.do";
	private final static String keyValue = "08702579";

	public void testQuery() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		QueryResult<ArticleInputData, Article> result = searcher.query("김치 재료 숙성");

		printQueryResult(result);
	}

	private void printQueryResult(QueryResult<ArticleInputData, Article> result) {

		System.out.printf("검색어  : %s%n", result.getInputData().getQuery());
		System.out.printf("검색대상: %s%n", result.getInputData().getTarget());
		for (Article article : result) {
			System.out.printf("%20s: %s %s%n", article.getCN(), article.getDbCode(), article.getTitle());
			System.out.printf("%20s  %s%n", "", article.getLinkForDesktop());
		}
	}

	public void testQuery2() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		QueryResult<ArticleInputData, Article> result = searcher.queryAll("LED", Target.DIKO, 1, 10);

		printQueryResult(result);
	}
}
