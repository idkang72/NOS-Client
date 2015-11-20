package net.waglewagle.nos;

public interface INdslRecord {

	/**
	 * <p>NDSL 콘텐츠 식별값을 얻는다.</p>
	 *
	 * @return NDSL 콘텐츠 식별값.
	 */
	String getKistiID();

	/**
	 * <p>NDSL 콘텐츠 식별값을 얻는다.</p>
	 * <p>{@link #getKistiID()} 호출한 결과와 같다.</p>
	 *
	 * @return
	 */
	String getCN();

}