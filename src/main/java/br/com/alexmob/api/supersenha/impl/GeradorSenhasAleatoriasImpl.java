package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.GeradorSenhasAleatorias;

import static br.com.alexmob.Constantes.*;
import static br.com.alexmob.utils.UtilsMath.getRandom;
import static br.com.alexmob.utils.UtilsString.sortear;

/**
 * Created by alexandre on 01/11/14.
 */
public class GeradorSenhasAleatoriasImpl implements GeradorSenhasAleatorias {

    private static final String alfabeto = vogais + consoantes;
    private static final String maiusculas = alfabeto.toUpperCase();


    @Override
    public String gerarSenhaNumerica(int tamanho) {
        return gerar(tamanho, numeros);
    }



    public String gerar(int tamanho, String cadeia) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int n = getRandom().nextInt(cadeia.length());
            sb.append(sortear(cadeia));
        }
        return sb.toString();
    }


    @Override
    public String gerarSenhaAlfanumerica(int tamanho) {
        return gerar(tamanho, numeros + alfabeto);
    }


    @Override
    public String gerarSenhaAlfanumericaCase(int tamanho) {
        return gerar(tamanho, numeros + alfabeto + maiusculas);
    }

    @Override
    public String gerarSenhaAlfanumericaCaseCaracteresEspeciais(int tamanho) {
        return gerar(tamanho, numeros + alfabeto+ maiusculas + caracteres_especiais);
    }
}
