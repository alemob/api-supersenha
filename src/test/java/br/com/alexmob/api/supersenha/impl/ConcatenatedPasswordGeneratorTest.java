package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.Constants;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConcatenatedPasswordGeneratorTest {

	private static final String wordListWithErrors = "abacate\nabacateiro\nabacaxi\nabafo\nabano\nabastecer\nabac ate\n\n\n\n\n\rmorango";
	private static final String wordlist = "brasil";

	private List<String> getResultWordListWithErrors () {
		List<String> l = new ArrayList<String> ();
		l.add ("abacate");
		l.add ("abacateiro");
		l.add ("abacaxi");
		l.add ("abafo");
		l.add ("abano");
		l.add ("abastecer");
		l.add ("abacate");
		l.add ("morango");
		return l;
	}

	@Before
	public void setUp () throws Exception {
		ConcatenatedPasswordGenerator g = new ConcatenatedPasswordGenerator (new StringReader (wordListWithErrors));
	}

	@Test
	public void testCreateWordList () throws Exception {
		ConcatenatedPasswordGenerator g = new ConcatenatedPasswordGenerator (new StringReader (wordListWithErrors));
		final List<String> wordList = g.getWordList ();
		assertEquals (wordList, getResultWordListWithErrors ());
	}

	@Test
	public void testGenerateConcatenatedPassword_semArquivo () throws Exception {
		ConcatenatedPasswordGenerator g = new ConcatenatedPasswordGenerator (new StringReader (wordlist));
		String r = g.createConcatenatedPassword (3, 2);
		int count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		assertTrue (StringUtils.containsAny (r, Constants.special_chars));
		r = g.createConcatenatedPassword (3, 0);
		count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		assertTrue (StringUtils.containsNone (r, Constants.special_chars));
		r = g.createConcatenatedPassword (3, "@.");
		count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		count = StringUtils.countMatches (r, "@.");
		assertTrue (count == 2);
		assertEquals (r, "brasil@.brasil@.brasil");
	}

	@Test
	public void testGenerateConcatenatedPassword_usandoArquivoExemplo () throws Exception {
		FileReader fileReader1 = new FileReader ("src/test/resources/mit.10000.words.txt");
		FileReader fileReader2 = new FileReader ("src/test/resources/mit.10000.words.txt");
		ConcatenatedPasswordGenerator g1 = new ConcatenatedPasswordGenerator (fileReader1, new ConcatenatedPasswordGenerator.WordFilter (3, 16));
		ConcatenatedPasswordGenerator g2 = new ConcatenatedPasswordGenerator (fileReader2);
		fileReader1.close ();
		fileReader2.close ();
		String r = g1.createConcatenatedPassword (3, 2);
		assertTrue (StringUtils.containsAny (r, Constants.special_chars));
		r = g1.createConcatenatedPassword (3, 0);
		assertTrue (StringUtils.containsNone (r, Constants.special_chars));
	}
}