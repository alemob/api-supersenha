package br.com.alexmob.api.supersenha.impl;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GeradorSenhasConcatenadasImplTest {

	private static final String wordlist = "abacate\nabacateiro\nabacaxi\nabafo\nabano\nabastecer\nabac ate\n\n\n\n\n\rmorango";

	private List<String> getListaResultado  () {
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
		GeradorSenhasConcatenadasImpl g = new GeradorSenhasConcatenadasImpl (new StringReader (wordlist));
	}


	@Test
	public void testCriarWordList () throws Exception {
		GeradorSenhasConcatenadasImpl gerada = new GeradorSenhasConcatenadasImpl (new StringReader (wordlist));
		final List<String> wordList = gerada.getWordList ();
		assertEquals (wordList, getListaResultado ());
	}

	@Test
	public void testGerarSenhaConcatenada () throws Exception {


	}

	@Test
	public void testGerarSenhaConcatenada1 () throws Exception {

	}





}