package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.utils.UtilsMath;
import br.com.alexmob.utils.UtilsString;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.Constants.special_chars;

/**
 * Created by alexandre on 03/11/14.
 */
public class ConcatenatedPasswordGenerator {

	final private List<String> wordList;

	public ConcatenatedPasswordGenerator (Reader reader, WordFilter filter) {
		wordList = createWordList (reader, filter);
	}

	public ConcatenatedPasswordGenerator (Reader reader) {
		this (reader, null);
	}

	public List<String> getWordList () {
		return wordList;
	}

	private List<String> createWordList (Reader reader, WordFilter filter) {
		List<String> wordList = new ArrayList<String> ();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader (reader);
			String line = bufferedReader.readLine ();
			while (line != null) {
				int min = Integer.MIN_VALUE;
				int max = Integer.MAX_VALUE;
				if (filter != null) {
					min = filter.getMinSize ();
					max = filter.getMaxSize ();
				}
				String filtered = filterBySize (line, min, max);
				if (filtered != null) {
					wordList.add (filtered);
				}
				line = bufferedReader.readLine ();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException ("File Not Found!");
		} catch (IOException e) {
			throw new RuntimeException (e.getMessage ());
		} finally {

		}

		return wordList;
	}

	private String filterBySize (String word, int min, int max) {
		if (word == null || word.trim ().isEmpty () || word.length () < min || word.length () > max)
			return null;
		return word.replaceAll ("\\p{Z}", "");
	}

	public String createConcatenatedPassword (int numberOfWords, int numberOfSpecialCharsSeparators) {
		StringBuilder sb = new StringBuilder ();
		String sorteado = null;
		if (numberOfSpecialCharsSeparators > 0) {
			sorteado = UtilsString.sortear (special_chars);
		}

		for (int i = 0; i < numberOfWords; i++) {
			final int index = UtilsMath.getRandom ().nextInt (wordList.size ());
			final String word = wordList.get (index);
			sb.append (word);
			if (i != numberOfWords - 1) {
				for (int j = 0; j < numberOfSpecialCharsSeparators; j++) {
					sb.append (sorteado);
				}
			}
		}
		return sb.toString ();
	}

	public String createConcatenatedPassword (int numberOfWords, String separatorChars) {
		StringBuilder sb = new StringBuilder ();

		for (int i = 0; i < numberOfWords; i++) {
			final int index = UtilsMath.getRandom ().nextInt (wordList.size ());
			final String word = wordList.get (index);
			sb.append (word);
			if (i != numberOfWords - 1) {
				sb.append (separatorChars);
			}
		}
		return sb.toString ();
	}

	public static class WordFilter {
		private final int minSize;
		private final int maxSize;

		WordFilter (int minSize, int maxSize) {
			this.minSize = minSize;
			this.maxSize = maxSize;
		}

		public int getMinSize () {
			return minSize;
		}

		public int getMaxSize () {
			return maxSize;
		}
	}
}
