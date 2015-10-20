package net.waglewagle.nos.util;

public class ValueUtil {
	public static int parseInt(String str) {
		return parseInt(str, 0);
	}


	public static int parseInt(String str, int def) {
		if ( str == null ) return def;

		int val = def;
		try {
			val = Integer.parseInt(str);
		}
		catch (NumberFormatException ignored) {

		}

		return val;
	}


	public static Float parseFloat(String str) {
		return parseFloat(str, 0F);
	}


	public static Float parseFloat(String str, float def) {
		if ( str == null ) return def;

		Float val = def;
		try {
			val = Float.parseFloat(str);
		}
		catch (NumberFormatException ignored) {

		}

		return val;
	}
}
