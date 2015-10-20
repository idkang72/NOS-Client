package net.waglewagle.nos.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringResponseHandler extends BaseResponseHandler<String> {
	public String handle(InputStream is, String encoding) throws IOException {
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

		return str;
	}

}
