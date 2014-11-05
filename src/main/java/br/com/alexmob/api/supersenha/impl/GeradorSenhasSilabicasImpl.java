package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.Constantes;

import static br.com.alexmob.Constantes.*;
import static br.com.alexmob.utils.UtilsMath.getRandom;
import static br.com.alexmob.utils.UtilsString.sortear;

/**
 * Created by alexandre on 02/11/14.
 */
public class GeradorSenhasSilabicasImpl {

	public String gerar (int tamanho, String consoantes, boolean consoanteUpper, String vogais, String numeros, String... extra) {
		StringBuilder sb = new StringBuilder ();
		int i = 0;
		do {
			sb.append (sortear (consoantes, consoanteUpper && getRandom ().nextBoolean ()));
			sb.append (sortear (vogais, false));
			sb.append (sortear (numeros, false, getRandom ().nextInt (2) + 1));
			if (extra != null) {
				for (String e : extra) {
					if (e != null && ! e.trim ().equals ("")) {
						sb.append (sortear (e, false));
					}
				}
			}
		} while (sb.length () < tamanho);
		return sb.substring (0, tamanho);
	}

	public String gerarSenhaSilabicaAlfaNumerica (int tamanho) {
		return gerar (tamanho, consoantes, false, vogais, numeros, null);
	}

	public String gerarSenhaSilabicaAlfaNumericeCase (int tamanho) {
		return gerar (tamanho, consoantes, true, vogais, numeros, null);
	}

	public String gerarSenhaSilabicaAlfaNumericaCaseCaracteresEspeciais (int tamanho) {
		return gerar (tamanho, consoantes, true, vogais, numeros, Constantes.caracteres_especiais);
	}
}
