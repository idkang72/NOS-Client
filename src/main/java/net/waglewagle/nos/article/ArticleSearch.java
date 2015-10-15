package net.waglewagle.nos.article;

import net.waglewagle.nos.QueryResult;

/**
 * 논문 검색 Interface.
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public interface ArticleSearch {
	public QueryResult query(String query, int page, int pageSize);

	public QueryResult query(Target target, SearchField field, ResponseGroup responseGroup, String query);
}
