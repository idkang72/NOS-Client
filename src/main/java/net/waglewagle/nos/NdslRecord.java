package net.waglewagle.nos;

public class NdslRecord {
	/** NDSL 콘텐츠 식별값(CN): record[kistiID]. */
	private String kistiID;

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
}
