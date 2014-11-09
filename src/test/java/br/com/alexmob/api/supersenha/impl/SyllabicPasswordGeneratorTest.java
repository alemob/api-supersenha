package br.com.alexmob.api.supersenha.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.Constants.*;
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
		assertTrue (containsNone (s, capital_letters + special_chars));
		assertTrue (containsAny (s, alphabet));
		assertTrue (containsAny (s, numbers));
	}

	@Test
	public void testCreateAlphanumericCaseSensitive () throws Exception {
		final String s = g.createAlphanumericCaseSensitive (20);
		assertTrue (containsNone (s, special_chars));
		assertTrue (containsAny (s, alphabet));
		assertTrue (containsAny (s, numbers));
	}

	@Test
	public void testCreateAlphanumericCaseSensitiveSpecialChars () throws Exception {
		final String s = g.createAlphanumericCaseSensitiveSpecialChars (20);
		assertTrue (containsAny (s, alphabet));
		assertTrue (containsAny (s, numbers));
		assertTrue (containsAny (s, special_chars));
	}
}