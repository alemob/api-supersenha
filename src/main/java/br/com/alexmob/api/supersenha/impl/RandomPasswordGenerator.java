package br.com.alexmob.api.supersenha.impl;

import static br.com.alexmob.Constants.*;
import static br.com.alexmob.utils.UtilsMath.getRandom;
import static br.com.alexmob.utils.UtilsString.sortear;

/**
 * Created by alexandre on 01/11/14.
 */
public class RandomPasswordGenerator {

	public String createNumeric (int tamanho) {
		return createPassword (tamanho, numbers);
	}

	private String createPassword (int size, String charList) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < size; i++) {
			int n = getRandom ().nextInt (charList.length ());
			sb.append (sortear (charList));
		}
		return sb.toString ();
	}

	public String createAlphanumeric (int size) {
		return createPassword (size, numbers + alphabet);
	}

	public String createAlphanumericCaseSensitive (int size) {
		return createPassword (size, numbers + alphabet + capital_letters);
	}

	public String createAlphanumericCaseSensitiveSpecialChars (int size) {
		return createPassword (size, numbers + alphabet + capital_letters + special_chars);
	}
}
