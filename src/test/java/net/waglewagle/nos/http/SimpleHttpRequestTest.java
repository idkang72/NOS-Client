package net.waglewagle.nos.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class SimpleHttpRequestTest extends TestCase {
	private final static String baseUrl = "http://openapi.ndsl.kr/itemsearch.do?keyValue=08702579";

	public void testGet() {
		SimpleHttpRequest httpReq = new SimpleHttpRequest(baseUrl);

		StringResponseHandler handler = new StringResponseHandler();

		Map<String, String> param = new HashMap<String, String>();

		param.put("target"       , "ARTI"   );
		param.put("searchField"  , "BI"     );
		param.put("displayCount" , "2"      );
		param.put("startPosition", "1"      );
		param.put("sortby"       , "pubyear");
		param.put("returnType"   , "xml"    );
		param.put("responseGroup", "simple" );
		param.put("query"        , "LED"    );

		try {
			String result = httpReq.get(param, handler);

			System.out.println(result);

			assertTrue(result.length() > 100);
		}
		catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}


	public void testGetForError() {
		SimpleHttpRequest httpReq = new SimpleHttpRequest(baseUrl);

		StringResponseHandler handler = new StringResponseHandler();

		Map<String, String> param = null;

		try {
			httpReq.get(param, handler);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), true);
		}
	}


	public void testGet2() {
		SimpleHttpRequest httpReq = new SimpleHttpRequest(baseUrl);

		StringResponseHandler handler = new StringResponseHandler();

		Map<String, String> param = new HashMap<String, String>();

		param.put("target"       , "ARTI"   );
		param.put("searchField"  , "BI"     );
		param.put("displayCount" , "10"      );
		param.put("startPosition", "1"      );
		param.put("query"        , "김치 재료 숙성");

		try {
			String result = httpReq.get(param, handler);

			System.out.println(result);
		}
		catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
