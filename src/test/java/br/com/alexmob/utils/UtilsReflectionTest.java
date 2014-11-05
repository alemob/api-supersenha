package br.com.alexmob.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexandre on 04/11/14.
 */
public class UtilsReflectionTest {

	@Test
	public void testInvokeMethod () throws Exception {
		Whatever w = new Whatever ();
		Object r = UtilsReflection.invokeMethod (w, "privateMethod", 1, "x");
		assertEquals (r, Integer.valueOf (1));
		r = UtilsReflection.invokeMethod (w, "privateMethod", 2, "x", new String[] {"x", "y"});
		assertEquals (r, Integer.valueOf (2));
	}

	private class Whatever {

		public Integer privateMethod (Integer i, String s) {
			return 1;
		}

		public Integer privateMethod (Integer i, String s, String... x) {
			return 2;
		}
	}
}
