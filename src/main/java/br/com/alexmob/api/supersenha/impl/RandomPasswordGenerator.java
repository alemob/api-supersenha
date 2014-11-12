package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.utils.UtilsString;

import static br.com.alexmob.utils.UtilsMath.getRandom;

/**
 * Created by alexandre on 01/11/14.
 */
public class RandomPasswordGenerator {

	public String createRandomPassword (int size, String charList) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < size; i++) {
			int n = getRandom ().nextInt (charList.length ());
			sb.append (UtilsString.pickUp (charList));
		}
		return sb.toString ();
	}
}
