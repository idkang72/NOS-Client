package net.waglewagle.nos.article;

import java.util.List;

/**
 * <p>NDSL 기사 정보를 담는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 19
 */
public class Article {
	/** 콘텐츠 유형: record[dbCode] */
	private String dbCode;

	private Target target;

	/** NDSL 콘텐츠 식별값(CN): record[kistiID]. */
	private String kistiID;

	/** 저널 객체. */
	private Journal journal;

	/** 제목: record/articleInfo/articleTitleInfo/articleTitle. */
	private String title;

	/** 초록: record/articleInfo/abstractInfo/abstract. */
	private String abs;

	/** 저자 목록:  record/articleInfo/authorInfo/author  */
	private List<Author> authorList;

	/** 원문보기 URL: record/articleInfo/content_url */
	private String contentUrl;

	/** 원문유무(1: 없음, 2: 있음): record/articleInfo/urlflag. */
	private boolean hasContent;

	/** 초록유무(1: 없음, 2: 있음): record/articleInfo/abstractflag. */
	private boolean hasAbstract;

	/** 소장여부: record/articleInfo/holdflag. */
	private boolean hasPaper;

	/** 총 페이지(저널내 수록 위치): record/articleInfo/page. */
	private String page;

	/** NDSL PC용 웹 상세보기 URL: record/articleInfo/deeplink. */
	private String linkForDesktop;

	/** NDSL 모바일용 웹 상세보기 URL: record/articleInfo/mobilelink. */
	private String linkForMobile;

	/** 주제어. record/articleInfo/keyword. */
	private List<String> keywordList;

	/**
	 * @return the dbCode
	 */
	public String getDbCode() {
		return dbCode;
	}

	/**
	 * @param dbCode the dbCode to set
	 */
	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

	/**
	 * @return the target
	 */
	public Target getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Target target) {
		this.target = target;
	}

	/**
	 * @return the kistiID
	 */
	public String getKistiID() {
		return kistiID;
	}


	/**
	 * <p>NDSL 콘텐츠식별값을 얻는다.</p>
	 * <p>{@link #getKistiID()} 호출한 결과와 같다.</p>
	 *
	 * @return
	 */
	public String getCN() {
		return kistiID;
	}

	/**
	 * @param kistiID the kistiID to set
	 */
	public void setKistiID(String kistiID) {
		this.kistiID = kistiID;
	}

	/**
	 * @return the journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * @param journal the journal to set
	 */
	public void setJournal(Journal journal) {
		this.journal = journal;
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
	 * @return the abs
	 */
	public String getAbs() {
		return abs;
	}

	/**
	 * @param abs the abs to set
	 */
	public void setAbs(String abs) {
		this.abs = abs;
	}

	/**
	 * @return the authorList
	 */
	public List<Author> getAuthorList() {
		return authorList;
	}

	/**
	 * @param authorList the authorList to set
	 */
	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
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

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the linkForDesktop
	 */
	public String getLinkForDesktop() {
		return linkForDesktop;
	}

	/**
	 * @param linkForDesktop the linkForDesktop to set
	 */
	public void setLinkForDesktop(String linkForDesktop) {
		this.linkForDesktop = linkForDesktop;
	}

	/**
	 * @return the linkForMobile
	 */
	public String getLinkForMobile() {
		return linkForMobile;
	}

	/**
	 * @param linkForMobile the linkForMobile to set
	 */
	public void setLinkForMobile(String linkForMobile) {
		this.linkForMobile = linkForMobile;
	}

	/**
	 * @return the keywordList
	 */
	public List<String> getKeywordList() {
		return keywordList;
	}

	/**
	 * @param keywordList the keywordList to set
	 */
	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}
}
