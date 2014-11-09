package br.com.alexmob.utils;

import br.com.alexmob.Constants;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsStringTest {



	@Test
	public void testSortear () {
		String s = UtilsString.sortear ("x");
		assertEquals (s, "x");

		s = UtilsString.sortear ("abc123");
		assertTrue (StringUtils.containsAny (s, "abc123"));

		s = UtilsString.sortear ("abc", true);
		assertTrue (StringUtils.containsAny (s, "ABC"));

		s = UtilsString.sortear ("abc", false, 10);
		assertTrue (s.length () == 10);
		assertTrue (StringUtils.containsOnly (s, "abc"));

		s = UtilsString.sortear ("abc", true, 10);
		assertTrue (s.length () == 10);
		assertTrue (StringUtils.containsOnly (s, "ABC"));
	}
}