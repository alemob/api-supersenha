package br.com.alexmob.api.supersenha.impl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static br.com.alexmob.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomPasswordGeneratorTest {

	RandomPasswordGenerator generator;

	@Before
	public void setUp () throws Exception {
		generator = new RandomPasswordGenerator ();
	}

	@Test
	public void testCreateRandomPassword_numbers () throws Exception {
		for (int i = 1; i < 10000; i++) {
			final String s = generator.createRandomPassword (10, NUMBERS);
			assertTrue (StringUtils.containsOnly (s, NUMBERS));
		}
	}

	@Test
	public void testCreateRandomPassword_all () throws Exception {
		int size = 400;
		final String s = generator.createRandomPassword (size, CAPITAL_LETTERS + NUMBERS + SPECIAL_CHARS + ALPHABET);
		assertTrue (StringUtils.containsOnly (s, CAPITAL_LETTERS + NUMBERS + SPECIAL_CHARS + ALPHABET));
		assertEquals (s.length (), size);
	}

	@Test
	public void testCreateRandomPassword_size0 () throws Exception {
		int size = 0;
		final String s = generator.createRandomPassword (size, CAPITAL_LETTERS + NUMBERS + SPECIAL_CHARS + ALPHABET);
		assertEquals (s, "");
		assertEquals (s.length (), size);
	}
}