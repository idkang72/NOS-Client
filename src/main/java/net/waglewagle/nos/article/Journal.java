package net.waglewagle.nos.article;

import java.util.ArrayList;
import java.util.List;

import net.waglewagle.nos.NdslRecord;

/**
 * 저널 정보를 담는 클래스.
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class Journal extends NdslRecord  {
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
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the issnList
	 */
	public List<String> getIssnList() {
		return issnList;
	}

	/**
	 * @param issnList the issnList to set
	 */
	public void setIssnList(List<String> issnList) {
		this.issnList = issnList;
	}

	public void addIssn(String issn) {
		if ( issn == null || "".equals(issn.trim()) ) return;

		if ( this.issnList == null ) {
			this.issnList = new ArrayList<String>();
		}

		this.issnList.add(issn);
	}

	/**
	 * @return the isbn
	 */
	public List<String> getIsbnList() {
		return isbnList;
	}

	/**
	 * @param isbnList the isbn to set
	 */
	public void setIsbnList(List<String> isbnList) {
		this.isbnList = isbnList;
	}


	public void addIsbn(String isbn) {
		if ( isbn == null || "".equals(isbn.trim()) ) return;

		if ( this.isbnList == null ) {
			this.isbnList = new ArrayList<String>();
		}

		this.isbnList.add(isbn);
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the contentUrl
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * @param contentUrl the contentUrl to set
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	/**
	 * @return the hasContent
	 */
	public boolean isHasContent() {
		return hasContent;
	}

	/**
	 * @param hasContent the hasContent to set
	 */
	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}

	/**
	 * @return the hasAbstract
	 */
	public boolean isHasAbstract() {
		return hasAbstract;
	}

	/**
	 * @param hasAbstract the hasAbstract to set
	 */
	public void setHasAbstract(boolean hasAbstract) {
		this.hasAbstract = hasAbstract;
	}

	/**
	 * @return the hasPaper
	 */
	public boolean isHasPaper() {
		return hasPaper;
	}

	/**
	 * @param hasPaper the hasPaper to set
	 */
	public void setHasPaper(boolean hasPaper) {
		this.hasPaper = hasPaper;
	}



}
