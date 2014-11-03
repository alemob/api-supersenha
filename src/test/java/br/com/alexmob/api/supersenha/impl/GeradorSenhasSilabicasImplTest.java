package br.com.alexmob.api.supersenha.impl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alexmob.Constantes.*;
import static org.junit.Assert.assertTrue;

public class GeradorSenhasSilabicasImplTest {

    static List<String> lista = new ArrayList<String>();
    GeradorSenhasSilabicasImpl g;

    @Before
    public void setUp() {

        g = new GeradorSenhasSilabicasImpl();
    }

    @Test
    public void gerarLista() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            lista.add("" + i);
            if (i % 1000000 == 0)
                System.out.println(i);
        }
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

    }

    @Test
    public void testGerarSenhaSilabicaAlfaNumericeCase() throws Exception {

    }

    @Test
    public void testGerarSenhaSilabicaAlfaNumericaCaseCaracteresEspeciais() throws Exception {

    }
}