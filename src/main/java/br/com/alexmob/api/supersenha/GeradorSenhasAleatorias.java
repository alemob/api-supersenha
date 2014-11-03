package br.com.alexmob.api.supersenha;

/**
 * Created by alexandre on 01/11/14.
 */
public interface GeradorSenhasAleatorias {

	String gerarSenhaNumerica (int tamanho);

	String gerarSenhaAlfanumerica (int tamanho);

	String gerarSenhaAlfanumericaCase (int tamanho);

	String gerarSenhaAlfanumericaCaseCaracteresEspeciais (int tamanho);
}

