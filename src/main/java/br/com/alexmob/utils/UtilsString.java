package br.com.alexmob.utils;

/**
 * Created by alexandre on 01/11/14.
 */
public class UtilsString {
    public static final boolean haveIt(String string, String caracteresBuscados) {
        for (int i = 0; i < caracteresBuscados.length(); i++) {
            caracteresBuscados.charAt(i);
            if (string.contains(""+caracteresBuscados.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}

