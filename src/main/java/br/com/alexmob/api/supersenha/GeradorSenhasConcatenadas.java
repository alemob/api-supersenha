package br.com.alexmob.api.supersenha;

import java.io.File;

/**
 * Created by alexandre on 03/11/14.
 */
public interface GeradorSenhasConcatenadas {
	String gerarSenhaConcatenada (int numberOfWords, int specialCharBetween);
	String gerarSenhaConcatenada (int numberOfWords, String separator);

}
