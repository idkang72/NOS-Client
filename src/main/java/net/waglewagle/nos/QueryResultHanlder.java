package net.waglewagle.nos;

import java.io.InputStream;

/**
 * <p>OpenAPI 조회결과를 처리하는 Handler Interface</p>
 * @author idkang72
 *
 */
public interface QueryResultHanlder<I extends InputData, E> {
	public QueryResult<I, E> handle(InputStream is);
}
