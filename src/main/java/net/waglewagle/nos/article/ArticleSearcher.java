/**
 *
 */
package net.waglewagle.nos.article;

import java.util.HashMap;
import java.util.Map;

import net.waglewagle.nos.QueryResult;
import net.waglewagle.nos.Searcher;

/**
 * <p>논문 검색 구현 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20.
 */
public class ArticleSearcher
extends Searcher<ArticleInputData, NdslArticle> implements ArticleSearch {
	private final static int DEF_MAX_COUNT = 10;

	/**
	 * 논문 검색 객체를 생성한다.
	 *
	 * @param keyValue 인증키.
	 * @param apiBaseUrl API 기본 URL값.
	 */
	public ArticleSearcher(String keyValue, String apiBaseUrl) {
		super(keyValue, apiBaseUrl);
	}


	public QueryResult<ArticleInputData, NdslArticle> query(String query) {
		return query(query, 1);
	}


	public QueryResult<ArticleInputData, NdslArticle> query(String query, int page) {
		return query(query, page, DEF_MAX_COUNT);
	}


	public QueryResult<ArticleInputData, NdslArticle> query(String query, int page, int pageSize) {
		return queryAll(query, (page - 1) * pageSize + 1);
	}


	public QueryResult<ArticleInputData, NdslArticle> queryAll(String query, int startPosition) {
		return queryAll(query, startPosition, DEF_MAX_COUNT);
	}


	public QueryResult<ArticleInputData, NdslArticle> queryAll(String query, int startPosition, int maxCount) {
		return queryAll(query, Target.ARTI, startPosition, maxCount);
	}


	public QueryResult<ArticleInputData, NdslArticle> queryAll(String query, Target target, int startPosition, int maxCount) {
		ArticleInputData inputData = new ArticleInputData();

		inputData.setQuery(query);
		inputData.setStartPosition(startPosition);
		inputData.setDisplayCount(maxCount);
		inputData.setTarget(target);

		inputData.setSearchField(SearchField.BI);

		return query(inputData);
	}


	public QueryResult<ArticleInputData, NdslArticle> query(ArticleInputData inputData) {
		Map<String, String> param = new HashMap<String, String>();

		param.put("displayCount" , String.valueOf(inputData.getDisplayCount ()));
		param.put("startPosition", String.valueOf(inputData.getStartPosition()));
		param.put("query"        , inputData.getQuery());

		if ( inputData.getTarget()        != null ) param.put("target"       , inputData.getTarget().name());

		if ( inputData.getSearchField()   != null ) param.put("searchField"  , inputData.getSearchField().name());
		if ( inputData.getSortBy()        != null ) param.put("sortby"       , inputData.getSortBy().getValue());
		if ( inputData.getReturnType()    != null ) param.put("returnType"   , inputData.getReturnType().getValue());
		if ( inputData.getResponseGroup() != null ) param.put("responseGroup", inputData.getResponseGroup().getValue() );

		ArticleSearchResultHandler handler = new ArticleSearchResultHandler();

		return search(param, handler);
	}
}
