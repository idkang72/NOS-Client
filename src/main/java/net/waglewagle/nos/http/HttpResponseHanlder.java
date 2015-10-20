package net.waglewagle.nos.http;

import java.io.IOException;
import java.io.InputStream;

public interface HttpResponseHanlder<T> {
	public final static String DEF_ENCODING = "UTF-8";

	public T handle(InputStream is) throws IOException;

	public T handle(InputStream is, String encoding) throws IOException;
}
