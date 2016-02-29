package net.waglewagle.nos;

import java.util.List;

/**
 * NDSL 저널 정보 Interface.
 *
 * @author 강신원
 * @since 2015. 11. 17.
 */
public interface INdslJournal extends INdslRecord {

	/**
	 * 출판사명을 얻는다.
	 *
	 * @return 출판사명.
	 */
	public String getPublisher();

	/**
	 * 제목을 얻는다.
	 *
	 * @return 제목.
	 */
	public String getTitle();

	/**
	 * 최근정보변경일자를 얻는다.
	 *
	 * @return 최근정보변경일자.
	 */
	public String getLastModifiedDate();

	/**
	 * 최근정보변경일자를 설정한다.
	 *
	 * @param lastModifiedDate 설정할 최근정보변경일자.
	 */
	public void setLastModifiedDate(String lastModifiedDate);


	/**
	 * ISSN 목록을 얻는다.
	 *
	 * @return ISSN 목록.
	 */
	public List<String> getIssnList();

	/**
	 * ISBN 목록을 얻는다.
	 *
	 * @return ISBN.
	 */
	public List<String> getIsbnList();

	/**
	 * 권 정보를 얻는다.
	 *
	 * @return 권 정보.
	 */
	public String getVolume();

	/**
	 * 권호제어번호 정보를 얻는다.
	 *
	 * @return 권호제어번호 정보.
	 */
	public String getVolumeSeqNo();


	/**
	 * 호 정보를 얻는다.
	 *
	 * @return 호 정보.
	 */
	public String getIssue();

	/**
	 * 발행연도를 얻는다.
	 *
	 * @return 발행연도.
	 */
	public String getYear();

	/**
	 * 원문보기 URL을 얻는다.
	 *
	 * @return 원문보기 URL.
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
	 * 소장 여부를 얻는다.
	 *
	 * @return 소장 여부.
	 */
	public boolean hasPaper();

}
