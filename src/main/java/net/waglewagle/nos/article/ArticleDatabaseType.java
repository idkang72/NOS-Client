package net.waglewagle.nos.article;

/**
 * <p>논문 검색대상 콘텐츠</p>
 *
 * @author 강신원
 * @since 2015. 10. 15
 */
public enum ArticleDatabaseType {
	ARTI("논문전체"),
	NART("국내학위논문만 제외"),
	JAKO("국내학술지"),
	JAFO("해외학술지"),
	CFKO("국내회의자료"),
	CFFO("해외회의자료"),
	DIKO("국내학위논문");

	/** 명칭. */
	private final String title;

	private ArticleDatabaseType(String title) {
		this.title = title;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
}
