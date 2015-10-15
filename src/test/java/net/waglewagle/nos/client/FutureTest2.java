package net.waglewagle.nos.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest2 {
	private final static String openApiUrl = "http://openapi.ndsl.kr/itemsearch.do?keyValue=00000000&target=ARTI&searchField=BI&displayCount=10&startPosition=1&sortby=pubyear&returnType=xml&responseGroup=simple&query=LED";

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		Future<Reader> future = executorService.submit(new Callable<Reader>() {
			public Reader call() throws Exception {
				URL url = new URL(openApiUrl);

				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

				String encoding = httpCon.getContentEncoding();

				if ( encoding == null ) encoding = "UTF-8";

				InputStream is = httpCon.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, encoding);
				BufferedReader    br = new BufferedReader(isr);

				//httpCon.disconnect();

				return br;
			}
		});

		Reader reader = future.get();

		StringBuffer buff = new StringBuffer();

		char [] cbuf = new char[2048];

		int readCount = -1;
		while ( (readCount = reader.read(cbuf)) > -1 ) {
			buff.append(cbuf, 0, readCount)
				.append('\n');
		}

		String result = buff.toString();

		buff.delete(0, buff.length());
		buff = null;

		System.out.println(result);

		reader.close();
		reader = null;


		executorService.shutdown();
	}
}
