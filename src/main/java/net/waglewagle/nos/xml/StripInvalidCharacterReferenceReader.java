package net.waglewagle.nos.xml;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>XML 1.0 기준, XML내 잘 못된 문자 참조(Character Reference)가 있으면 제거하는 Filter Reader</p>
 *
 * @author 강신원
 * @since 2015. 11. 20.
 */
public class StripInvalidCharacterReferenceReader extends FilterReader {

	public StripInvalidCharacterReferenceReader(Reader in) {
		super(in);
	}




	/* (non-Javadoc)
	 * @see java.io.BufferedReader#read(char[], int, int)
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int readCount = super.read(cbuf, off, len);

		if ( readCount < 0 ) return readCount;

		String str = new String(cbuf, off, readCount);
		char [] stripedCbuf = stripInvalidCharacterReference(str).toCharArray();

		System.arraycopy(stripedCbuf, 0, cbuf, off, stripedCbuf.length);

		return stripedCbuf.length;
	}





	/** XML 문자 참조(Character Reference)를 찾기 위한 패턴. */
	private final Pattern nonValidPattern = Pattern.compile("&#(x?)([0-9a-fA-F]+);");

	/**
	 * XML 문자 참조 중 잘 못된 것을 찾아 제거한다.
	 *
	 * @param str 잘못된 XML 문자 참조를 제거할 문자열.
	 * @return 잘못된 XML 문자 참조가 제거된 문자열.
	 */
	public String stripInvalidCharacterReference(String str) {
		if ( str == null || "".equals(str) ) return str;

		StringBuffer out = new StringBuffer();
		Matcher matcher = nonValidPattern.matcher(str);
		int value = 0;
		boolean isHex = false;
		boolean valid = false;
		while (matcher.find()) {
			isHex = "x".equals(matcher.group(1));
			value = Integer.parseInt(matcher.group(2), isHex ? 16 : 10);
			valid = false;
			if ((value == 0x9) ||
					(value == 0xA) ||
					(value == 0xD) ||
					((value >= 0x20) && (value <= 0xD7FF)) ||
					((value >= 0xE000) && (value <= 0xFFFD)) ||
					((value >= 0x10000) && (value <= 0x10FFFF))) {
				valid = true;
			}

			if ( ! valid ) {
				matcher.appendReplacement(out, "");
			}
		}
		matcher.appendTail(out);

		return out.toString();
	}

}
