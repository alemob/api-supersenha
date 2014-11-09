package br.com.alexmob.utils;

import static br.com.alexmob.utils.UtilsMath.getRandom;

/**
 * Created by alexandre on 01/11/14.
 */
public class UtilsString {

	public static String pickUp (String charList) {
		return String.valueOf (charList.charAt (getRandom ().nextInt (charList.length ())));
	}

	public static String pickUp (String charList, boolean isUpper) {
		return isUpper ? pickUp (charList).toUpperCase () : pickUp (charList);
	}

	public static String pickUp (String charList, boolean isUpper, int count) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < count; i++) {
			sb.append (pickUp (charList, isUpper));
		}
		return sb.toString ();
	}
}

