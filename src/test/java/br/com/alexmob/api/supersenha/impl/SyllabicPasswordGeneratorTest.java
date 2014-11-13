package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.impl.SyllabicPasswordGenerator.PatternType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.Constants.*;
import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.containsNone;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SyllabicPasswordGeneratorTest {

	static List<String> lista = new ArrayList<String> ();
	SyllabicPasswordGenerator g;

	@Before
	public void setUp () {
		g = new SyllabicPasswordGenerator ();
	}

	@Test
	public void testCreateSyllabicPassword () {
		final String s = g.createSyllabicPassword (10000, CONSONANTS, VOWELS, NUMBERS, SPECIAL_CHARS, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
		assertEquals (s.length (), 10000);
		assertTrue (containsNone (s));
		assertTrue (containsAny (s, CONSONANTS + VOWELS + SPECIAL_CHARS));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_consoantsIsNull () {
		final String s = g.createSyllabicPassword (100, null, VOWELS, NUMBERS, SPECIAL_CHARS, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_consoantsIsEmpty () {
		final String s = g.createSyllabicPassword (100, "", VOWELS, NUMBERS, SPECIAL_CHARS, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_vowelIsNull () {
		final String s = g.createSyllabicPassword (1000, CONSONANTS, null, NUMBERS, SPECIAL_CHARS, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_vowelIsIsEmpty () {
		final String s = g.createSyllabicPassword (10000, CONSONANTS, "", NUMBERS, SPECIAL_CHARS, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
	}

	@Test
	public void testCreateSyllabicPassword_nullConsonantsAndSpecial () {
		final String s = g.createSyllabicPassword (10000, CONSONANTS, VOWELS, null, null, new PatternType[] {PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
		assertEquals (s.length (), 10000);
		assertTrue (containsNone (s, NUMBERS + SPECIAL_CHARS));
		assertTrue (containsAny (s, CONSONANTS + VOWELS));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_nullArrayPatternType () {
		final String s = g.createSyllabicPassword (10000, CONSONANTS, VOWELS, null, null, null);
		assertEquals (s.length (), 10000);
		assertTrue (containsNone (s, NUMBERS + SPECIAL_CHARS));
		assertTrue (containsAny (s, CONSONANTS + VOWELS));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSyllabicPassword_emptyArrayPatternType () {
		final String s = g.createSyllabicPassword (10000, CONSONANTS, VOWELS, null, null, new PatternType[]{null,null});
		assertEquals (s.length (), 10000);
		assertTrue (containsNone (s, NUMBERS + SPECIAL_CHARS));
		assertTrue (containsAny (s, CONSONANTS + VOWELS));
	}


	public void testCreateSyllabicPassword_variousSamePatterns () {
		final String s = g.createSyllabicPassword (1000, CONSONANTS, VOWELS, null, null, new PatternType[]{PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE,PatternType.SYLLABLE});
		assertEquals (s.length (), 1000);
		assertTrue (containsNone (s, NUMBERS + SPECIAL_CHARS));
		assertTrue (containsAny (s, CONSONANTS + VOWELS));
	}


}