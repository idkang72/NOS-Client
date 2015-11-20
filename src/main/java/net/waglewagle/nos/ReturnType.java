package net.waglewagle.nos;

public enum ReturnType {
	XML("xml"), JSON("json");

	/** 값. */
	private final String value;

	private ReturnType(String value) {
		this.value = value;
	}


	/**
	 * 값을 얻는다.
	 *
	 * @return
	 */
	public String getValue() {
		return this.value;
	}


	public static ReturnType find(String name) {
	    for (ReturnType e : values()) {
	        if (e.value.equals(name)) {
	            return e;
	        }
	    }

	    return null;
	}
}
