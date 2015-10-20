package net.waglewagle.nos.jodd;

import java.io.IOException;
import java.io.InputStream;

import jodd.http.HttpConnection;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.io.StreamUtil;
import junit.framework.TestCase;

public class HttpTest extends TestCase {
	private final static String openApiUrl = "http://openapi.ndsl.kr/itemsearch.do?keyValue=08702579&target=ARTI&searchField=BI&displayCount=10&startPosition=1&sortby=pubyear&returnType=xml&responseGroup=simple&query=LED";

	public void test1() {
		HttpRequest httpReq = HttpRequest.get(openApiUrl);

		HttpResponse httpRes = httpReq.send();

		String result = httpRes.body();

		System.out.println(result);
	}


	public void test2() throws IOException {
		HttpRequest httpReq = HttpRequest.get(openApiUrl);

		HttpConnection httpConn = httpReq.open().httpConnection();

		InputStream is = httpConn.getInputStream();

		char [] chars = StreamUtil.readChars(is, "UTF-8");

		System.out.println(new String(chars));

		httpConn.close();
	}
}
