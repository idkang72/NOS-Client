package net.waglewagle.nos.article;

import java.util.ArrayList;
import java.util.List;

import net.waglewagle.nos.INdslArticle;
import net.waglewagle.nos.INdslJournal;
import net.waglewagle.nos.NdslRecord;

/**
 * <p>NDSL 기사 정보를 담는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 19
 */
public class NdslArticle extends NdslRecord implements INdslArticle {
	/** 콘텐츠 유형: record[databaseCode] */
	private String databaseCode;

	private ArticleDatabaseType databaseType;

	/** 저널 객체. */
	private INdslJournal journal;

	/** 제목: record/articleInfo/articleTitleInfo/articleTitle. */
	private String title;

	/** 초록: record/articleInfo/abstractInfo/abstract. */
	private String abs;

	/** 저자 목록:  record/articleInfo/authorInfo/author  */
	private List<NdslAuthor> authorList;

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
	 * <p>논문의 콘텐츠 유형 코드를 얻는다.</p>
	 */
	public String getDatabaseCode() {
		return databaseCode;
	}

	/**
	 * <p>논문의 콘텐츠 유형 코드를 설정한다.</p>
	 *
	 * @param databaseCode 설정할 콘텐츠 유형 코드.
	 */
	public void setDatabaseCode(String dbCode) {
		this.databaseCode = dbCode;

		if ( dbCode == null ) {
			this.databaseType = null;
		}
		else {
			this.databaseType = ArticleDatabaseType.valueOf(dbCode);
		}
	}


	/**
	 * <p>논문의 콘텐츠 유형을 얻는다.</p>
	 */
	public ArticleDatabaseType getDatabaseType() {
		return databaseType;
	}


	/**
	 * <p>논문의 콘텐츠 유형을 설정한다.</p>
	 *
	 * @param databaseType the databaseType to set
	 */
	public void setDatabaseType(ArticleDatabaseType dbType) {
		this.databaseType = dbType;

		if ( dbType == null ) {
			this.databaseCode = null;
		}
		else {
			this.databaseCode = dbType.name();
		}
	}


	/**
	 * <p>저널 정보를 얻는다.</p>
	 *
	 * @return 저널 정보.
	 */
	public INdslJournal getJournal() {
		return journal;
	}

	/**
	 * <p>저널 정보를 설정한다.</p>
	 *
	 * @param journal 설정할 저널 정보.
	 */
	public void setJournal(INdslJournal journal) {
		this.journal = journal;
	}


	/**
	 * 논문 제목을 얻는다.
	 *
	 * @return 논문 제목.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 논문 제목을 설정한다.
	 *
	 * @param title 설정할 논문 제목.
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * 초록을 얻는다.
	 *
	 * @return 초록.
	 */
	public String getAbstract() {
		return abs;
	}

	/**
	 * 초록을 설정한다.
	 *
	 * @param abs 설정할 초록.
	 */
	public void setAbstract(String abs) {
		this.abs = abs;
	}

	/**
	 * 저자 목록을 얻는다.
	 *
	 * @return 저자 목록.
	 */
	public List<NdslAuthor> getAuthorList() {
		return authorList;
	}

	/**
	 * 저자 목록을 설정한다.
	 *
	 * @param authorList 설정할 저자 목록.
	 */
	public void setAuthorList(List<NdslAuthor> authorList) {
		this.authorList = authorList;
	}

	/**
	 * 저자 목록에 저자를 추가한다.
	 *
	 * @param authorName 추가할 저자명.
	 */
	public void addAuthor(String authorName) {
		if ( authorName == null || "".equals(authorName.trim())) return;

		addAuthor(new NdslAuthor(authorName));
	}


	/**
	 * 저자 목록에 저자를 추가한다.
	 *
	 * @param author 추가할 저자 정보.
	 */
	public void addAuthor(NdslAuthor author) {
		if ( this.authorList == null ) {
			this.authorList = new ArrayList<NdslAuthor>();
		}

		this.authorList.add(author);
	}


	/**
	 * 원문접근 URL을 얻는다.
	 *
	 * @return 원문접근 URL.
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * 원문접근 URL을 설정한다.
	 *
	 * @param contentUrl 설정할 원문접근 URL.
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
	 * 원문 소장 여부를 얻는다.
	 *
	 * @return 원문 소장 여부.
	 */
	public boolean hasPaper() {
		return hasPaper;
	}

	/**
	 * 원문 소장 여부를 설정한다.
	 *
	 * @param hasPaper 설정할 원문 소장 여부.
	 */
	public void setHasPaper(boolean hasPaper) {
		this.hasPaper = hasPaper;
	}

	/**
	 * 저널 내 수록 페이지 정보를 얻는다.
	 *
	 * @return 저널 내 수록 페이지 정보.
	 */
	public String getPage() {
		return page;
	}

	/**
	 * 저널 내 수록 페이지 정보를 설정한다.
	 *
	 * @param page 설정할 저널 내 수록 페이지 정보.
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * PC용 상세보기 URL을 얻는다.
	 *
	 * @return PC용 상세보기 URL.
	 */
	public String getLinkForDesktop() {
		return linkForDesktop;
	}

	/**
	 * PC용 상세보기 URL을 설정한다.
	 *
	 * @param linkForDesktop 설정할 PC용 상세보기 URL.
	 */
	public void setLinkForDesktop(String linkForDesktop) {
		this.linkForDesktop = linkForDesktop;
	}

	/**
	 * 모바일기기용 상세보기 URL을 얻는다.
	 *
	 * @return 모바일기기용 상세보기 URL.
	 */
	public String getLinkForMobile() {
		return linkForMobile;
	}

	/**
	 * 모바일기기용 상세보기 URL을 설정한다.
	 *
	 * @param linkForMobile 설정할 모바일기기용 상세보기 URL.
	 */
	public void setLinkForMobile(String linkForMobile) {
		this.linkForMobile = linkForMobile;
	}


	/**
	 * 주제어 목록을 얻는다.
	 *
	 * @return 주제어 목록.
	 */
	public List<String> getKeywordList() {
		return keywordList;
	}

	/**
	 * 주제어 목록을 설정한다.
	 *
	 * @param keywordList 설정할 주제어 목록.
	 */
	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}

	/**
	 * <p>주제어 목록에 주제어를 추가한다.</p>
	 * <p>파라미터 keyword의 값이 빈 값이면 추가되지 않는다.</p>
	 *
	 * @param keyword 추가할 주제어 목록.
	 */
	public void addKeyword(String keyword) {
		if ( keyword == null || "".equals(keyword.trim()) ) return;

		if ( this.keywordList == null ) {
			this.keywordList = new ArrayList<String>();
		}

		this.keywordList.add(keyword);
	}
}
