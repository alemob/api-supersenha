package br.com.alexmob.api.supersenha;

import br.com.alexmob.api.supersenha.entity.GuessResult;

import java.util.List;

/**
 * Created by alexandre on 06/11/14.
 */
public interface PasswordStrengthCalculator {

	float calculateEntropyByNIST (String password);
	GuessResult calculateSecondsToCrack (String password, float entropy, double guessesPerSecond, List<String> wordList);

}
