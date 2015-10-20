package net.waglewagle.nos.article;

import net.waglewagle.nos.QueryResult;

/**
 * 논문 검색 Interface.
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public interface ArticleSearch {
	public QueryResult<ArticleInputData, Article> query(String query);

	public QueryResult<ArticleInputData, Article> query(String query, int page);

	public QueryResult<ArticleInputData, Article> query(String query, int page, int pageSize);

	public QueryResult<ArticleInputData, Article> queryAll(String query, int startPosition);

	public QueryResult<ArticleInputData, Article> queryAll(String query, int startPosition, int maxCount);

	public QueryResult<ArticleInputData, Article> query(ArticleInputData inputData);
}
