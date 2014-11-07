package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.PasswordStrengthCalculator;

import java.math.BigDecimal;

/**
 * Created by alexandre on 06/11/14.
 */
public class PasswordStrengthCalculatorImpl implements PasswordStrengthCalculator {

	@Override
	public double calculateEntropyByNIST (String password) {
		int size = password.trim ().length ();
		if (size == 0) {
			return 0.0;
		}
		double bits = 4.0f;
		for (int i = 1; i < password.length (); i++) {
			if (i <= 8) {
				bits += 2f;
			} else if (i <= 20) {
				bits += 1.5f;
			} else {
				bits += 1f;
			}
		}
		if (isMixCase (password) && isNonAlfaNumeric (password)) {
			bits += 6;
		}
		return bits;
	}

	//TODO: implement
	private boolean isNonAlfaNumeric (String password) {
		return false;
	}

	//TODO: implement
	private boolean isMixCase (String password) {
		return false;
	}
}
