package net.waglewagle.nos;

public class NdslRecord implements INdslRecord {
	/** NDSL 콘텐츠 식별값(CN): record[kistiID]. */
	private String kistiID;

	/**
	 * <p>NDSL 콘텐츠 식별값을 얻는다.</p>
	 *
	 * @return NDSL 콘텐츠 식별값.
	 */
	public String getKistiID() {
		return kistiID;
	}


	/**
	 * <p>NDSL 콘텐츠 식별값을 얻는다.</p>
	 * <p>{@link #getKistiID()} 호출한 결과와 같다.</p>
	 *
	 * @return
	 */
	public String getCN() {
		return kistiID;
	}


	/**
	 * <p>NDSL 콘텐츠 식별값을 설정한다.</p>
	 *
	 * @param kistiID 설정할 콘텐츠 식별값.
	 */
	public void setKistiID(String kistiID) {
		this.kistiID = kistiID;
	}
}
