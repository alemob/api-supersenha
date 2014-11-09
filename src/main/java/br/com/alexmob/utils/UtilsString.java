package br.com.alexmob.utils;

import static br.com.alexmob.utils.UtilsMath.getRandom;

/**
 * Created by alexandre on 01/11/14.
 */
public class UtilsString {

	//TODO: traduzir
	public static String sortear (String charList) {
		return String.valueOf (charList.charAt (getRandom ().nextInt (charList.length ())));
	}

	public static String sortear (String charList, boolean isUpper) {
		return isUpper ? sortear (charList).toUpperCase () : sortear (charList);
	}

	public static String sortear (String charList, boolean isUpper, int count) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < count; i++) {
			sb.append (sortear (charList, isUpper));
		}
		return sb.toString ();
	}
}

