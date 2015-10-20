package net.waglewagle.nos.article;

/**
 * <p>국내학위 논문 정보를 담는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class Dissertation extends Article {
	private String schoolName;

	/** 학위 구분. */
	private String degree;

	/** 발간년도. */
	private String year;

	/** 보관 장소. */
	private String holdingPlace;

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
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
	 * @return the holdingPlace
	 */
	public String getHoldingPlace() {
		return holdingPlace;
	}

	/**
	 * @param holdingPlace the holdingPlace to set
	 */
	public void setHoldingPlace(String holdingPlace) {
		this.holdingPlace = holdingPlace;
	}

}
