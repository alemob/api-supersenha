package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.GeradorSenhasConcatenadas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandre on 03/11/14.
 */
public class GeradorSenhasConcatenadasImpl implements GeradorSenhasConcatenadas {

	final private List<String> wordList;

	public GeradorSenhasConcatenadasImpl (Reader reader, WordFilter filter) {
		wordList = criarWordList (reader, filter);
	}

	public GeradorSenhasConcatenadasImpl (Reader reader) {
		this (reader, null);
	}

	public List<String> getWordList () {
		return wordList;
	}

	private List<String> criarWordList (Reader reader, WordFilter filter) {
		List<String> lista = new ArrayList<String> ();
		try {
			BufferedReader br = new BufferedReader (reader);
			String line = br.readLine ();
			while (line != null) {
				int min = Integer.MIN_VALUE;
				int max = Integer.MAX_VALUE;
				if (filter != null) {
					min = filter.getMinSize ();
					max = filter.getMaxSize ();
				}
				String filtrada = filtrar (line, min, max);
				if (filtrada != null) {
					lista.add (filtrada);
				}
				line = br.readLine ();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException ("arquivo não existe");
		} catch (IOException e) {
			throw new RuntimeException (e.getMessage ());
		}
		return lista;
	}

	private String filtrar (String word, int min, int max) {
		if (word == null || word.trim ().isEmpty () || word.length () < min || word.length () > max)
			return null;
		return word.replaceAll ("\\p{Z}", "");
	}

	@Override
	public String gerarSenhaConcatenada (int specialCharBetween, int words) {

		return null;
	}

	@Override
	public String gerarSenhaConcatenada (int words, char... separatorChars) {
		return null;
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
