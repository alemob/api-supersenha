package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.Constants;

import static br.com.alexmob.Constants.*;
import static br.com.alexmob.utils.UtilsMath.getRandom;
import static br.com.alexmob.utils.UtilsString.sortear;

/**
 * Created by alexandre on 02/11/14.
 */
public class SyllabicPasswordGenerator {

	private String createPassword (int passwordSize, String consonants, boolean canConsonantsBeCapitalLetters, String vowels, String numbers, String... extra) {
		StringBuilder sb = new StringBuilder ();
		int i = 0;
		do {
			sb.append (sortear (consonants, canConsonantsBeCapitalLetters && getRandom ().nextBoolean ()));
			sb.append (sortear (vowels, false));
			sb.append (sortear (numbers, false, getRandom ().nextInt (2) + 1));
			if (extra != null) {
				for (String e : extra) {
					if (e != null && ! e.trim ().equals ("")) {
						sb.append (sortear (e, false));
					}
				}
			}
		} while (sb.length () < passwordSize);
		return sb.substring (0, passwordSize);
	}

	public String createAlphanumeric (int passwordSize) {
		return createPassword (passwordSize, consonants, false, vowels, numbers, null);
	}

	public String createAlphanumericCaseSensitive (int passwordSize) {
		return createPassword (passwordSize, consonants, true, vowels, numbers, null);
	}

	public String createAlphanumericCaseSensitiveSpecialChars (int passwordSize) {
		return createPassword (passwordSize, consonants, true, vowels, numbers, Constants.special_chars);
	}
}
