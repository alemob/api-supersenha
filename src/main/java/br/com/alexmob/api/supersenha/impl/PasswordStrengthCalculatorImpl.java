package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.PasswordStrengthCalculator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by alexandre on 06/11/14.
 */
public class PasswordStrengthCalculatorImpl implements PasswordStrengthCalculator {

	@Override
	public float calculateEntropyByNIST (String password) {
		password = password.trim ();
		int size = password.length ();
		if (size == 0) {
			return 0.0f;
		}
		float bits = 0;
		for (int i = 0; i < password.length (); i++) {
			if (i == 0) {
				bits += 4f;
				continue;
			}
			if (i < 8f) {
				bits += 2f;
			} else if (i < 20f) {
				bits += 1.5f;
			} else {
				bits += 1f;
			}
		}
		System.out.println (password);
		if (isMixCase (password) && oneOfItIsNonAlfaNumeric (password)) {
			bits += 6;
		}
		return bits;
	}

	private boolean oneOfItIsNonAlfaNumeric (String password) {
		for (int i = 0; i < password.length (); i++) {
			if (! StringUtils.isAlphanumeric (String.valueOf (password.charAt (i)))) {
				return true;
			}
		}
		return false;
	}

	private boolean isMixCase (String password) {
		return ! (StringUtils.isAllLowerCase (password) && StringUtils.isAllUpperCase (password));
	}
}
