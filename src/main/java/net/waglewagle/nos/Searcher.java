package net.waglewagle.nos;

import java.util.Map;

import net.waglewagle.nos.http.HttpResponseHanlder;
import net.waglewagle.nos.http.SimpleHttpRequest;

/**
 * NDSL OpenAPI 검색 요청 부모 클래스.
 *
 * @author 강신원
 * @since  2015. 10. 20.
 */
public abstract class Searcher<I extends InputData, E> {
	private SimpleHttpRequest httpRequest;

	/** 인증키. */
	private String keyValue;

	/** 요청 기본 URL. */
	private String apiUrl;

	/**
	 * 인증키와 함께 Searcher 객체를 생성한다.
	 *
	 * @param keyValue 인증키.
	 */
	public Searcher(String keyValue, String apiUrl) {
		this.keyValue = keyValue;
		this.apiUrl   = apiUrl;
		this.httpRequest = new SimpleHttpRequest(apiUrl + "?keyValue=" + keyValue);
	}

	/**
	 * @return the keyValue
	 */
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue the keyValue to set
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	/**
	 * @return the apiUrl
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * @param apiUrl the apiUrl to set
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}


	public <T> T search(Map<String, String> param, HttpResponseHanlder<T> handler) {
		T result = null;

		try {
			result = this.httpRequest.get(param, handler);
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new NosException(e);
		}

		return result;
	}
}
