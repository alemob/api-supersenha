package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.GeradorSenhasAleatorias;
import org.junit.Before;
import org.junit.Test;

import static br.com.alexmob.api.supersenha.impl.GeradorSenhasAleatoriasImpl.*;
import static br.com.alexmob.utils.UtilsString.haveIt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeradorSenhasAleatoriasImplTest {

    GeradorSenhasAleatorias g;

    @Before
    public void setUp() throws Exception {
        g = new GeradorSenhasAleatoriasImpl();

    }

    @Test
    public void testGerarSenhaNumerica() throws Exception {
        for (int i = 1; i < 10000; i++) {
            final String s = g.gerarSenhaNumerica(10);
            assertTrue(haveIt(s, numeros));
            assertFalse(haveIt(s, alfabeto + maiusculas + especiais));
        }

    }

    @Test
    public void testGerarSenhaAlfanumerica() throws Exception {
        for (int i = 1; i < 10000; i++) {
            final String s = g.gerarSenhaAlfanumerica(10);
            assertTrue(haveIt(s, alfabeto + numeros));
            assertFalse(haveIt(s, especiais + maiusculas));

        }
    }


    @Test
    public void testGerarSenhaAlfanumericaComMaiusculas() throws Exception {
        for (int i = 1; i < 10000; i++) {
            final String s = g.gerarSenhaAlfanumericaComMaiusculas(10);
            assertTrue(haveIt(s, maiusculas + numeros + alfabeto));
            assertFalse(haveIt(s, especiais));
        }


    }

    @Test
    public void testGerarSenhaAlfanumericaComCaracteresEspeciais() throws Exception {
        for (int i = 1; i < 10000; i++) {
            final String s = g.gerarSenhaAlfanumericaComMaiusculas(10);
            assertTrue(haveIt(s, especiais + maiusculas + numeros + alfabeto));
        }

    }


}