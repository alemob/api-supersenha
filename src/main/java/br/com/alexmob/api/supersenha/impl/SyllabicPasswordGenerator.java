package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.PasswordConstants;
import br.com.alexmob.utils.UtilsString;

import static br.com.alexmob.PasswordConstants.*;
import static br.com.alexmob.utils.UtilsMath.getRandom;
import static br.com.alexmob.utils.UtilsString.pickUp;

/**
 * Created by alexandre on 02/11/14.
 */
public class SyllabicPasswordGenerator {

	private String createPassword (int passwordSize, String consonants, boolean canConsonantsBeCapitalLetters, String vowels, String numbers, String... extra) {
		StringBuilder sb = new StringBuilder ();
		int i = 0;
		do {
			sb.append (UtilsString.pickUp (consonants, canConsonantsBeCapitalLetters && getRandom ().nextBoolean ()));
			sb.append (UtilsString.pickUp (vowels, false));
			sb.append (pickUp (numbers, false, getRandom ().nextInt (2) + 1));
			if (extra != null) {
				for (String e : extra) {
					if (e != null && ! e.trim ().equals ("")) {
						sb.append (UtilsString.pickUp (e, false));
					}
				}
			}
		} while (sb.length () < passwordSize);
		return sb.substring (0, passwordSize);
	}

	public String createAlphanumeric (int passwordSize) {
		return createPassword (passwordSize, CONSONANTS, false, VOWELS, NUMBERS, null);
	}

	public String createAlphanumericCaseSensitive (int passwordSize) {
		return createPassword (passwordSize, CONSONANTS, true, VOWELS, NUMBERS, null);
	}

	public String createAlphanumericCaseSensitiveSpecialChars (int passwordSize) {
		return createPassword (passwordSize, CONSONANTS, true, VOWELS, NUMBERS, PasswordConstants.SPECIAL_CHARS);
	}
}
