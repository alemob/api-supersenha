package br.com.alexmob.api.supersenha.impl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.Constantes.*;
import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.containsNone;
import static org.junit.Assert.assertTrue;

public class GeradorSenhasSilabicasImplTest {

    static List<String> lista = new ArrayList<String>();
    GeradorSenhasSilabicasImpl g;

    @Before
    public void setUp() {
        g = new GeradorSenhasSilabicasImpl();
    }


    @Test
    public void testGerar() throws Exception {
        String s = g.gerar(10, "xxxx", false, "aaaa", numeros, null);
        assertTrue(s.length() == 10);
        s = g.gerar(10, consoantes, false, vogais, numeros, new String[]{});
        assertTrue(StringUtils.containsAny(s, consoantes));
        assertTrue(StringUtils.containsAny(s, vogais));
        s = g.gerar(10, consoantes, false, vogais, numeros, new String[]{caracteres_especiais, vogais, null});
        assertTrue(StringUtils.containsAny(s, caracteres_especiais));


    }

    @Test
    public void testGerarSenhaSilabicaAlfaNumerica() throws Exception {
        final String s = g.gerarSenhaSilabicaAlfaNumerica(20);
        assertTrue(containsNone(s, maiusculas + caracteres_especiais));
        assertTrue(containsAny(s, alfabeto));
        assertTrue(containsAny(s, numeros));
    }


    @Test
    public void testGerarSenhaSilabicaAlfaNumericeCase() throws Exception {
        final String s = g.gerarSenhaSilabicaAlfaNumericeCase(20);
        assertTrue(containsNone(s, caracteres_especiais));
        assertTrue(containsAny(s, alfabeto));
        assertTrue(containsAny(s, numeros));

    }


    @Test
    public void testGerarSenhaSilabicaAlfaNumericaCaseCaracteresEspeciais() throws Exception {
        final String s = g.gerarSenhaSilabicaAlfaNumericaCaseCaracteresEspeciais(20);
        assertTrue(containsAny(s, alfabeto));
        assertTrue(containsAny(s, numeros));
        assertTrue(containsAny(s, caracteres_especiais));
    }
}