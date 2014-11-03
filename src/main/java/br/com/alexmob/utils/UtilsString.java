package br.com.alexmob.utils;

import static br.com.alexmob.utils.UtilsMath.getRandom;

/**
 * Created by alexandre on 01/11/14.
 */
public class UtilsString {
	public static final boolean haveIt (String string, String caracteresBuscados) {
		for (int i = 0; i < caracteresBuscados.length (); i++) {
			caracteresBuscados.charAt (i);
			if (string.contains ("" + caracteresBuscados.charAt (i))) {
				return true;
			}
		}
		return false;
	}

	public static String sortear (String cadeia) {
		return String.valueOf (cadeia.charAt (getRandom ().nextInt (cadeia.length ())));
	}

	public static String sortear (String cadeia, boolean upper) {
		return upper ? sortear (cadeia).toUpperCase () : sortear (cadeia);
	}

	public static String sortear (String cadeia, boolean upper, int q) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < q; i++) {
			sb.append (sortear (cadeia, upper));
		}
		return sb.toString ();
	}
}

