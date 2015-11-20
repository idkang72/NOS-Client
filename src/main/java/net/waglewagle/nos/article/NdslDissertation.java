package net.waglewagle.nos.article;

import net.waglewagle.nos.INdslDissertation;

/**
 * <p>국내학위 논문 정보를 담는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class NdslDissertation extends NdslArticle implements INdslDissertation {
	/** 발행학교명. */
	private String schoolName;

	/** 학위 구분. */
	private String degree;

	/** 발간년도. */
	private String year;

	/** 보관 장소. */
	private String holdingPlace;

	/**
	 * 발행학교명을 얻는다.
	 *
	 * @return 발행학교명.
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * 발행학교명을 설정한다.
	 *
	 * @param schoolName 설정할 발행학교명.
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * 학위 구분을 얻는다.
	 *
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * 학위 구분을 설정한다.
	 *
	 * @param degree 설정할 학위 구분.
	 */
	public void setDegree(String degree) {
		this.degree = degree;
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
	 * 소장처를 얻는다.
	 *
	 * @return 소장처.
	 */
	public String getHoldingPlace() {
		return holdingPlace;
	}

	/**
	 * 소장처를 설정한다.
	 *
	 * @param holdingPlace 설정할 소장처.
	 */
	public void setHoldingPlace(String holdingPlace) {
		this.holdingPlace = holdingPlace;
	}

}
