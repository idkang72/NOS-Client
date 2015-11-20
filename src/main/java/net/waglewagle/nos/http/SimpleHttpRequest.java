package net.waglewagle.nos.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleHttpRequest {
	private final static Logger log = Logger.getLogger(SimpleHttpRequest.class.getName());

	private final static String DEF_CHARSET = "UTF-8";

	private String baseUrl;

	private String charset;

	public SimpleHttpRequest(String baseUrl) {
		this(baseUrl, DEF_CHARSET);
	}


	public SimpleHttpRequest(String baseUrl, String charset) {
		this.baseUrl = baseUrl;
		this.charset = charset;
	}


	private String makeUrlForGet(Map<String, String> param)
	throws UnsupportedEncodingException {
		if ( param == null || param.isEmpty() ) return "";

		StringBuilder buff = new StringBuilder(baseUrl);

		if ( buff.indexOf("?") < 0 ) {
			buff.append("?");
		}
		else {
			buff.append("&");
		}

		for (String key : param.keySet()) {
			String value = param.get(key);
			String encoded = value == null ? "" : URLEncoder.encode(value, charset);

			buff.append(key)
				.append("=")
				.append(encoded)
				.append("&");
		}

		String url = buff.substring(0, buff.length() - 1); // 끝에 & 제거.

		buff.delete(0,  buff.length());
		buff = null;

		log.log(Level.INFO, "URL: {0}", url);

		return url;
	}


	public <T> T get(Map<String, String> param, HttpResponseHanlder<T> handler)
	throws IOException {
		URL url = new URL(makeUrlForGet(param));

		URLConnection urlConn = url.openConnection();

		urlConn.setRequestProperty("Accept-Charset", charset);

		String encoding = urlConn.getContentEncoding();

		if ( encoding == null ) encoding = charset;

		InputStream is = urlConn.getInputStream();

		T result = handler.handle(is);

		is.close();

		return result;
	}
}
