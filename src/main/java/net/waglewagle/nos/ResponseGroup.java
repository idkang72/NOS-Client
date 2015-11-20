package net.waglewagle.nos;

/**
 * 응답 그룹.
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public enum ResponseGroup {
	SIMPLE ("simple" , "원문 라이선스 체크 하지 않음"),
	ADVANCE("advance", "원문 라이선스 체크 후 URL 제공");

	/** 값. */
	private final String value;

	/** 명칭. */
	private final String title;

	private ResponseGroup(String value, String title) {
		this.value = value;
		this.title = title;
	}


	/**
	 * 값을 얻는다.
	 *
	 * @return
	 */
	public String getValue() {
		return this.value;
	}


	/**
	 * 제목을 얻는다.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	public static ResponseGroup find(String name) {
	    for (ResponseGroup e : values()) {
	        if (e.value.equals(name)) {
	            return e;
	        }
	    }

	    return null;
	}
}
