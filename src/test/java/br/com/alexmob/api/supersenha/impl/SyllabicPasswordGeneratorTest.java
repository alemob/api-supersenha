package br.com.alexmob.api.supersenha.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.PasswordConstants.*;
import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.containsNone;
import static org.junit.Assert.assertTrue;

public class SyllabicPasswordGeneratorTest {

	static List<String> lista = new ArrayList<String> ();
	SyllabicPasswordGenerator g;

	@Before
	public void setUp () {
		g = new SyllabicPasswordGenerator ();
	}

	@Test
	public void testCreateAlphanumeric () throws Exception {
		final String s = g.createAlphanumeric (20);
		assertTrue (containsNone (s, CAPITAL_LETTERS + SPECIAL_CHARS));
		assertTrue (containsAny (s, ALPHABET));
		assertTrue (containsAny (s, NUMBERS));
	}

	@Test
	public void testCreateAlphanumericCaseSensitive () throws Exception {
		final String s = g.createAlphanumericCaseSensitive (20);
		assertTrue (containsNone (s, SPECIAL_CHARS));
		assertTrue (containsAny (s, ALPHABET));
		assertTrue (containsAny (s, NUMBERS));
	}

	@Test
	public void testCreateAlphanumericCaseSensitiveSpecialChars () throws Exception {
		final String s = g.createAlphanumericCaseSensitiveSpecialChars (20);
		assertTrue (containsAny (s, ALPHABET));
		assertTrue (containsAny (s, NUMBERS));
		assertTrue (containsAny (s, SPECIAL_CHARS));
	}
}