package net.waglewagle.nos;

import java.util.List;

import net.waglewagle.nos.article.ArticleDatabaseType;
import net.waglewagle.nos.article.NdslAuthor;

/**
 * NDSL 논문 정보 Interface.
 *
 * @author 강신원
 * @since 2015. 11. 17
 */
public interface INdslArticle extends INdslRecord {

	/**
	 * <p>논문의 콘텐츠 유형 코드를 얻는다.</p>
	 */
	public String getDatabaseCode();

	/**
	 * <p>논문의 콘텐츠 유형을 얻는다.</p>
	 */
	public ArticleDatabaseType getDatabaseType();

	/**
	 * <p>저널 정보를 얻는다.</p>
	 *
	 * @return 저널 정보.
	 */
	public INdslJournal getJournal();

	/**
	 * 논문 제목을 얻는다.
	 *
	 * @return 논문 제목.
	 */
	public String getTitle();

	/**
	 * 초록을 얻는다.
	 *
	 * @return 초록.
	 */
	public String getAbstract();

	/**
	 * 저자 목록을 얻는다.
	 *
	 * @return 저자 목록.
	 */
	public List<NdslAuthor> getAuthorList();

	/**
	 * 원문접근 URL을 얻는다.
	 *
	 * @return 원문접근 URL.
	 */
	public String getContentUrl();

	/**
	 * 원문 유무를 얻는다.
	 *
	 * @return 원문 유무.
	 */
	public boolean hasContent();

	/**
	 * 초록 유무를 얻는다.
	 *
	 * @return 초록 유무.
	 */
	public boolean hasAbstract();

	/**
	 * 원문 소장 여부를 얻는다.
	 *
	 * @return 원문 소장 여부.
	 */
	public boolean hasPaper();

	/**
	 * 저널 내 수록 페이지 정보를 얻는다.
	 *
	 * @return 저널 내 수록 페이지 정보.
	 */
	public String getPage();

	/**
	 * PC용 상세보기 URL을 얻는다.
	 *
	 * @return PC용 상세보기 URL.
	 */
	public String getLinkForDesktop();

	/**
	 * 모바일기기용 상세보기 URL을 얻는다.
	 *
	 * @return 모바일기기용 상세보기 URL.
	 */
	public String getLinkForMobile();

	/**
	 * 주제어 목록을 얻는다.
	 *
	 * @retrun 주제어 목록.
	 */
	public List<String> getKeywordList();

}