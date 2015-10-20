package net.waglewagle.nos;

/**
 * <p>NDSL OpenAPI 오류.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class NosException extends RuntimeException {
	public NosException() {
		super();
	}

	public NosException(String message, Throwable cause) {
		super(message, cause);
	}

	public NosException(String message) {
		super(message);
	}

	public NosException(Throwable cause) {
		super(cause);
	}
}
