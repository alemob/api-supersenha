package br.com.alexmob.api.supersenha;

/**
 * Created by alexandre on 01/11/14.
 */
public interface GeradorSenhasAleatorias {

    public String gerarSenhaNumerica (int tamanho);
    public String gerarSenhaAlfanumerica (int tamanho);
    public String gerarSenhaAlfanumericaComMaiusculas (int tamanho);
    public String gerarSenhaAlfanumericaComCaracteresEspeciais (int tamanho);




}

