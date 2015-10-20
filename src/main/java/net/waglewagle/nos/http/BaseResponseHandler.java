package net.waglewagle.nos.http;

import java.io.IOException;
import java.io.InputStream;

public abstract class BaseResponseHandler<T> implements HttpResponseHanlder<T> {
	public T handle(InputStream is) throws IOException {
		return handle(is, DEF_ENCODING);
	}

	public abstract T handle(InputStream is, String encoding) throws IOException;
}
