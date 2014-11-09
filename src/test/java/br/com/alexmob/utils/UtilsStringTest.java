package br.com.alexmob.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsStringTest {



	@Test
	public void testSortear () {
		String s = UtilsString.pickUp ("x");
		assertEquals (s, "x");

		s = UtilsString.pickUp ("abc123");
		assertTrue (StringUtils.containsAny (s, "abc123"));

		s = UtilsString.pickUp ("abc", true);
		assertTrue (StringUtils.containsAny (s, "ABC"));

		s = UtilsString.pickUp ("abc", false, 10);
		assertTrue (s.length () == 10);
		assertTrue (StringUtils.containsOnly (s, "abc"));

		s = UtilsString.pickUp ("abc", true, 10);
		assertTrue (s.length () == 10);
		assertTrue (StringUtils.containsOnly (s, "ABC"));
	}
}