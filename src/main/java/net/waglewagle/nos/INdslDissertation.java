package net.waglewagle.nos;

/**
 * <p>NDSL 국내학위 논문 Interface.</p>
 *
 * @author 강신원
 * @since 2015. 11. 17.
 */
public interface INdslDissertation extends INdslRecord {

	/**
	 * 발행학교명을 얻는다.
	 *
	 * @return 발행학교명.
	 */
	public String getSchoolName();

	/**
	 * 학위 구분을 얻는다.
	 *
	 * @return 학위 구분
	 */
	public String getDegree();

	/**
	 * 발행연도를 얻는다.
	 *
	 * @return 발행연도.
	 */
	public String getYear();

	/**
	 * 소장처를 얻는다.
	 *
	 * @return 소장처.
	 */
	public String getHoldingPlace();

}