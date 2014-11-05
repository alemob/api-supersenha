package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.Constantes;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeradorSenhasConcatenadasImplTest {

	private static final String wordlistComErros = "abacate\nabacateiro\nabacaxi\nabafo\nabano\nabastecer\nabac ate\n\n\n\n\n\rmorango";
	private static final String wordlist = "brasil";

	private List<String> getResultadoListaComErros () {
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
		GeradorSenhasConcatenadasImpl g = new GeradorSenhasConcatenadasImpl (new StringReader (wordlistComErros));
	}

	@Test
	public void testCriarWordList () throws Exception {
		GeradorSenhasConcatenadasImpl gerada = new GeradorSenhasConcatenadasImpl (new StringReader (wordlistComErros));
		final List<String> wordList = gerada.getWordList ();
		assertEquals (wordList, getResultadoListaComErros ());
	}

	@Test
	public void testGerarSenhaConcatenada () throws Exception {
		GeradorSenhasConcatenadasImpl gerador = new GeradorSenhasConcatenadasImpl (new StringReader (wordlist));
		String r = gerador.gerarSenhaConcatenada (3, 2);
		int count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		assertTrue (StringUtils.containsAny (r, Constantes.caracteres_especiais));
		r = gerador.gerarSenhaConcatenada (3, 0);
		count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		assertTrue (StringUtils.containsNone (r, Constantes.caracteres_especiais));
		r = gerador.gerarSenhaConcatenada (3, "@.");
		count = StringUtils.countMatches (r, wordlist);
		assertTrue (count == 3);
		count = StringUtils.countMatches (r, "@.");
		assertTrue (count == 2);
		assertEquals (r, "brasil@.brasil@.brasil");
	}


}