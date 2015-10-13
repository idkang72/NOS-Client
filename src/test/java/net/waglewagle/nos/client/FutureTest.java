package net.waglewagle.nos.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
	private final static ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	private final static String openApiUrl = "http://openapi.ndsl.kr/itemsearch.do?keyValue=00000000&target=ARTI&searchField=BI&displayCount=10&startPosition=1&sortby=pubyear&returnType=xml&responseGroup=simple&query=LED";

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Future<String> future = executorService.submit(new Callable<String>() {
			public String call() throws Exception {
				URL url = new URL(openApiUrl);

				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

				String encoding = httpCon.getContentEncoding();

				if ( encoding == null ) encoding = "UTF-8";

				InputStream is = httpCon.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, encoding);
				BufferedReader    br = new BufferedReader(isr);

				StringBuffer buff = new StringBuffer();

				String line = null;

				while ( (line = br.readLine()) != null ) {
					buff.append(line)
						.append('\n');
				}

				String str = buff.toString();

				buff.delete(0, buff.length());
				buff = null;

				br.close();
				httpCon.disconnect();

				return str;
			}
		});

		String result = future.get();

		System.out.println(result);
	}
}
