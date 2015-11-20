package net.waglewagle.nos.article;

import net.waglewagle.nos.INdslAuthor;

/**
 * NDSL 논문의 저자정보를 담는 클래스.
 *
 * @author 강신원
 * @size 2015. 10. 19.
 */
public class NdslAuthor implements INdslAuthor {
	/** 저자명. */
	private String name;

	/**
	 * 빈 NDSL 논문 저자 정보 객체를 생성한다.
	 */
	public NdslAuthor() {

	}

	/**
	 * 저자명으로 NDSL 논문 저자 정보 객체를 생성한다.
	 *
	 * @param name 저자명.
	 */
	public NdslAuthor(String name) {
		this.name = name;
	}


	/**
	 * 저자명을 얻는다.
	 *
	 * @return 저자명.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 저자명을 설정한다.
	 *
	 * @param name 설정할 저자명.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
