package net.waglewagle.nos;

/**
 * <p>NDSL 논문 검색 요청 정보를 담고 있는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class InputData {
	/** 인증키. */
	private String keyValue;

	/** 검색결과 최대 출력건수: 기본 10, 최대 100. */
	private int displayCount;

	/** 검셕결과 출력 시작위치. */
	private int startPosition;

	/** 검색질의어. */
	private String query;


	/**
	 * @return the keyValue
	 */
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue the keyValue to set
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	/**
	 * @return the displayCount
	 */
	public int getDisplayCount() {
		return displayCount;
	}

	/**
	 * @param displayCount the displayCount to set
	 */
	public void setDisplayCount(int displayCount) {
		this.displayCount = displayCount;
	}

	/**
	 * @return the startPosition
	 */
	public int getStartPosition() {
		return startPosition;
	}

	/**
	 * @param startPosition the startPosition to set
	 */
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
}
