package net.waglewagle.nos.article;

import java.util.ArrayList;
import java.util.List;

import net.waglewagle.nos.INdslJournal;
import net.waglewagle.nos.NdslRecord;

/**
 * 저널 정보를 담는 클래스.
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class NdslJournal extends NdslRecord implements INdslJournal  {
	/** 출판사명. */
	private String publisher;

	/** 저널명. */
	private String title;

	/** ISSN 목록. */
	private List<String> issnList;

	/** ISBN 목록. */
	private List<String> isbnList;

	/** 권. */
	private String volume;

	/** 호. */
	private String issue;

	/** 발행년도. */
	private String year;

	/** 원문보기 URL: record/journalInfo/content_url */
	private String contentUrl;

	/** 원문유무(1: 없음, 2: 있음): record/journalInfo/urlflag. */
	private boolean hasContent;

	/** 초록유무(1: 없음, 2: 있음): record/journalInfo/abstractflag. */
	private boolean hasAbstract;

	/** 소장여부: record/journalInfo/holdingflag. */
	private boolean hasPaper;

	/**
	 * 출판사명을 얻는다.
	 *
	 * @return 출판사명.
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 출판사명을 설정한다.
	 *
	 * @param publisher 설정할 출판사명.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 제목을 얻는다.
	 *
	 * @return 제목.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 제목을 설정한다.
	 *
	 * @param title 설정할 제목.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ISSN 목록을 얻는다.
	 *
	 * @return ISSN 목록.
	 */
	public List<String> getIssnList() {
		return issnList;
	}

	/**
	 * ISSN 목록을 설정한다.
	 *
	 * @param issnList 설정할 ISSN 목록.
	 */
	public void setIssnList(List<String> issnList) {
		this.issnList = issnList;
	}

	/**
	 * ISSN을 추가한다.
	 *
	 * @param issn 추가할 ISSN.
	 */
	public void addIssn(String issn) {
		if ( issn == null || "".equals(issn.trim()) ) return;

		if ( this.issnList == null ) {
			this.issnList = new ArrayList<String>();
		}

		this.issnList.add(issn);
	}


	/**
	 * ISBN 목록을 얻는다.
	 *
	 * @return ISBN.
	 */
	public List<String> getIsbnList() {
		return isbnList;
	}

	/**
	 * ISBN 목록을 설정한다.
	 *
	 * @param isbnList 설정할 ISBN 목록.
	 */
	public void setIsbnList(List<String> isbnList) {
		this.isbnList = isbnList;
	}


	/**
	 * ISBN을 추가한다.
	 *
	 * @param isbn 추가할 ISBN.
	 */
	public void addIsbn(String isbn) {
		if ( isbn == null || "".equals(isbn.trim()) ) return;

		if ( this.isbnList == null ) {
			this.isbnList = new ArrayList<String>();
		}

		this.isbnList.add(isbn);
	}


	/**
	 * 권 정보를 얻는다.
	 *
	 * @return 권 정보.
	 */
	public String getVolume() {
		return volume;
	}


	/**
	 * 권 정보를 설정한다.
	 *
	 * @param volume 설정할 권 정보.
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * 호 정보를 얻는다.
	 *
	 * @return 호 정보.
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * 호 정보를 설정한다.
	 *
	 * @param issue 설정할 호 정보.
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * 발행연도를 얻는다.
	 *
	 * @return 발행연도.
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 발행연도를 설정한다.
	 *
	 * @param year 설정할 발행연도.
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 원문보기 URL을 얻는다.
	 *
	 * @return 원문보기 URL.
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * 원문보기 URL을 설정한다.
	 *
	 * @param contentUrl 설정할 원문보기 URL.
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	/**
	 * 원문 유무를 얻는다.
	 *
	 * @return 원문 유무.
	 */
	public boolean hasContent() {
		return hasContent;
	}

	/**
	 * 원문 유무를 설정한다.
	 *
	 * @param hasContent 설정할 원문 유무.
	 */
	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}

	/**
	 * 초록 유무를 얻는다.
	 *
	 * @return 초록 유무.
	 */
	public boolean hasAbstract() {
		return hasAbstract;
	}

	/**
	 * 초록 유무를 설정한다.
	 *
	 * @param hasAbstract 설정할 초록 유무.
	 */
	public void setHasAbstract(boolean hasAbstract) {
		this.hasAbstract = hasAbstract;
	}

	/**
	 * 소장 여부를 얻는다.
	 *
	 * @return 소장 여부.
	 */
	public boolean hasPaper() {
		return hasPaper;
	}

	/**
	 * 소장 여부를 설정한다.
	 *
	 * @param hasPaper 설정할 소장 여부.
	 */
	public void setHasPaper(boolean hasPaper) {
		this.hasPaper = hasPaper;
	}
}
