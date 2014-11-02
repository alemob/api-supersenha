package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.GeradorSenhasAleatorias;

import java.util.Random;

/**
 * Created by alexandre on 01/11/14.
 */
public class GeradorSenhasAleatoriasImpl implements GeradorSenhasAleatorias {


    static final String numeros = "0123456789";
    static final String alfabeto = "abcdefghijklmnopqrstuvxzwy";
    static final String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVXZWY";
    static final String especiais = "!@#$%&*()_+-=[]/;.,{}?:><";
    static Random rand = new Random();

    @Override
    public String gerarSenhaNumerica(int tamanho) {
        return gerar(tamanho, numeros);
    }


    public char sortear(String cadeia) {
        return cadeia.charAt(rand.nextInt(cadeia.length()));
    }

    public String gerar(int tamanho, String cadeia) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int n = rand.nextInt(cadeia.length());
            sb.append(sortear(cadeia));
        }
        return sb.toString();
    }


    @Override
    public String gerarSenhaAlfanumerica(int tamanho) {
        return gerar(tamanho, numeros + alfabeto);
    }


    @Override
    public String gerarSenhaAlfanumericaComMaiusculas(int tamanho) {
        return gerar(tamanho, numeros + alfabeto + maiusculas);
    }

    @Override
    public String gerarSenhaAlfanumericaComCaracteresEspeciais(int tamanho) {
        return gerar(tamanho, numeros + alfabeto + maiusculas + especiais);
    }
}
