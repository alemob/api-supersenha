package br.com.alexmob.api.supersenha;

/**
 * Created by alexandre on 06/11/14.
 */
public interface PasswordStrengthCalculator {

	double calculateEntropyByNIST (String password);

}
