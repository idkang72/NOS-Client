package net.waglewagle.nos.article;

/**
 * 검색 대상 필드.
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public enum ArticleSearchField {
	BI("전체"),
	TI("제목"),
	AB("초록"),
	PB("발행기관"),
	AU("저자"),
	SN("ISSN"),
	BN("ISBN"),
	KW("키워드"),
	PY("발행연도"),
	EN("등록일자");

	/** 명칭. */
	private final String title;

	private ArticleSearchField(String title) {
		this.title = title;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
}
