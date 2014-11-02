package br.com.alexmob.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsStringTest {

    private static final String numeros = "0123456789";
    private static final String alfabeto =   "abcdefghijklmnopqrstuvxzwy";
    private static final String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVXZWY";
    private static final String especiais = "!@#$%&*()_+-=[]/;.,{}?:><";


    @Test
    public void testHaveIt() throws Exception {
        assertFalse(UtilsString.haveIt("", numeros));
        assertFalse(UtilsString.haveIt("a", numeros));
        assertTrue(UtilsString.haveIt("abc9", numeros));
        assertTrue(UtilsString.haveIt("0bc", numeros));
        assertTrue(UtilsString.haveIt("0", numeros));

        assertFalse(UtilsString.haveIt("", alfabeto));
        assertFalse(UtilsString.haveIt("1", alfabeto));
        assertTrue(UtilsString.haveIt("123y", alfabeto));
        assertTrue(UtilsString.haveIt("a01", alfabeto));
        assertTrue(UtilsString.haveIt("a", alfabeto));

        assertFalse(UtilsString.haveIt("", maiusculas));
        assertFalse(UtilsString.haveIt("y", maiusculas));
        assertTrue(UtilsString.haveIt("123Y", maiusculas));
        assertTrue(UtilsString.haveIt("A01", maiusculas));
        assertTrue(UtilsString.haveIt("A", maiusculas));

        assertFalse(UtilsString.haveIt("", especiais));
        assertFalse(UtilsString.haveIt("a", especiais));
        assertTrue(UtilsString.haveIt("123<", especiais));
        assertTrue(UtilsString.haveIt("!a01", especiais));
        assertTrue(UtilsString.haveIt("<", especiais));




    }
}