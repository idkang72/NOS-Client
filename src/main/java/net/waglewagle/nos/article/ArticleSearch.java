package net.waglewagle.nos.article;

import net.waglewagle.nos.QueryResult;

/**
 * 논문 검색 Interface.
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public interface ArticleSearch {
	public QueryResult<ArticleInputData, NdslArticle> query(String query);

	public QueryResult<ArticleInputData, NdslArticle> query(String query, int page);

	public QueryResult<ArticleInputData, NdslArticle> query(String query, int page, int pageSize);

	public QueryResult<ArticleInputData, NdslArticle> queryAll(String query, int startPosition);

	public QueryResult<ArticleInputData, NdslArticle> queryAll(String query, int startPosition, int maxCount);

	public QueryResult<ArticleInputData, NdslArticle> query(ArticleInputData inputData);
}
