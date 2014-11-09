package br.com.alexmob.api.supersenha.impl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static br.com.alexmob.Constants.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomPasswordGeneratorTest {

	RandomPasswordGenerator generator;
	String alphabet = vowels + consonants;
	String upper = alphabet.toUpperCase ();

	@Before
	public void setUp () throws Exception {
		generator = new RandomPasswordGenerator ();
	}

	@Test
	public void testCreateNumeric () throws Exception {
		for (int i = 1; i < 10000; i++) {
			final String s = generator.createNumeric (10);
			assertTrue (StringUtils.containsAny (s, numbers));
			assertFalse (StringUtils.containsAny (s, alphabet + upper + special_chars));
		}
	}

	@Test
	public void testCreateAlphanumeric () throws Exception {
		for (int i = 1; i < 10000; i++) {
			final String s = generator.createAlphanumeric (10);
			assertTrue (StringUtils.containsAny (s, alphabet + numbers));
			assertFalse (StringUtils.containsAny (s, special_chars + upper));
		}
	}

	@Test
	public void testCreateAlphanumericCaseSensitive () throws Exception {
		for (int i = 1; i < 10000; i++) {
			final String s = generator.createAlphanumericCaseSensitive (10);
			assertTrue (StringUtils.containsAny (s, upper + numbers + alphabet));
			assertFalse (StringUtils.containsAny (s, special_chars));
		}
	}

	@Test
	public void testCreateAlphanumericCaseSensitiveSpecialChars () throws Exception {
		for (int i = 1; i < 10000; i++) {
			final String s = generator.createAlphanumericCaseSensitiveSpecialChars (10);
			assertTrue (StringUtils.containsAny (s, special_chars + upper + numbers + alphabet));
		}
	}
}