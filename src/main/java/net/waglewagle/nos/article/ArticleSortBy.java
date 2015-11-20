package net.waglewagle.nos.article;

/**
 * <p>정렬기준 필드.</p>
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public enum ArticleSortBy {
	PUB_YEAR ("pubyear", "발행일"),
	ART_TITLE("title"  , "논문명"),
	JRL_TITLE("jtitle" , "저널명"),
	WEIGHT   ("NULL"   , "정확도");


	/** 값. */
	private final String value;

	/** 명칭. */
	private final String title;

	private ArticleSortBy(String value, String title) {
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


	public static ArticleSortBy find(String name) {
	    for (ArticleSortBy e : values()) {
	        if (e.value.equals(name)) {
	            return e;
	        }
	    }

	    return null;
	}
}
