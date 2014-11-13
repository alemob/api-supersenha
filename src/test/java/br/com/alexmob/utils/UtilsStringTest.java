package br.com.alexmob.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static br.com.alexmob.Constants.*;
import static org.junit.Assert.*;

public class UtilsStringTest {

	@Test
	public void testPickUp () {
		String s = UtilsString.pickUp ("x");
		assertEquals (s, "x");

		s = UtilsString.pickUp ("abc123");
		assertTrue (StringUtils.containsAny (s, "abc123"));
	}

	@Test
	public void testPickUpOneEach () {
		final String s = UtilsString.pickUpOneEach (new String[] {NUMBERS, VOWELS, SPECIAL_CHARS, CONSONANTS});
		assertTrue (s.length () == 4);
		assertTrue (StringUtils.containsAny (String.valueOf (s.charAt (0)), NUMBERS));
		assertTrue (StringUtils.containsAny (String.valueOf (s.charAt (1)), VOWELS));
		assertTrue (StringUtils.containsAny (String.valueOf (s.charAt (2)), SPECIAL_CHARS));
		assertTrue (StringUtils.containsAny (String.valueOf (s.charAt (3)), CONSONANTS));
		assertNotNull (s.charAt (0));
		assertNotNull (s.charAt (1));
		assertNotNull (s.charAt (2));
		assertNotNull (s.charAt (3));
	}

	@Test
	public void testPickUpOneEach_nullEmptyString () {
		final String s = UtilsString.pickUpOneEach (new String[] {});
		assertTrue (s.length () == 0);
		assertEquals (s, "");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testPickUpOneEach_arrayWithNulls () {
		final String s = UtilsString.pickUpOneEach (new String[] {null, null});
		assertTrue (s.length () == 0);
		assertEquals (s, "");
	}
}