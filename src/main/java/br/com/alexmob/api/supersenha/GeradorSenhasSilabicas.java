package br.com.alexmob.api.supersenha;

/**
 * Created by alexandre on 02/11/14.
 */
public interface GeradorSenhasSilabicas {

	String gerarSenhaSilabicaAlfaNumerica (int tamanho);

	String gerarSenhaSilabicaAlfaNumericeCase (int tamanho);

	String gerarSenhaSilabicaAlfaNumericaCaseCaracteresEspeciais (int tamanho);
}
