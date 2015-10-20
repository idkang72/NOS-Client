package net.waglewagle.nos;

public interface QueryResult<I extends InputData, E> extends Iterable<E> {
	/**
	 * 전체 검색결과 건수를 얻는다.
	 */
	public int getTotalCount();


	/**
	 * 검색 요청 처리시간(초) 값을 얻는다.
	 *
	 * @return
	 */
	public float getProcessingTime();


	/**
	 * 검색 요청 데이터를 얻는다.
	 *
	 * @return
	 */
	public I getInputData();


	/**
	 * 검색결과가 담고 있는 페이지가 몇 페이지인지를 얻는다.
	 *
	 * @return
	 */
	public int getPageNo();


	/**
	 * 가져온 검색결과 갯수를 얻는다.
	 *
	 * @return 가져온 검색 결과 갯수.
	 */
	public int getCount();
}
