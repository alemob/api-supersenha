package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.entity.StrengthResult;
import br.com.alexmob.api.supersenha.entity.Reason;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PasswordStrengthCalculatorImplTest {

	static final float DELTA = 0.001F;
	PasswordStrengthCalculatorImpl calculator;

	@Before
	public void setUp () {
		calculator = new PasswordStrengthCalculatorImpl ();
	}

	@Test
	public void testCalculateEntropyByNIST_blankspacespassword_expect0 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("    ");
		Assert.assertEquals (0.0, v, 0);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght1_Expect4 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("1 ");
		Assert.assertEquals (4.0, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght8_Expect20 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("12345678 ");
		Assert.assertEquals (18.0, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght20_Expect36 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("12345678901234567890 ");
		Assert.assertEquals (36, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght21_Expect37 () throws Exception {
		final float v = calculator.calculateEntropyByNIST (" 123456789012345678901 ");
		Assert.assertEquals (37, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght22_mixCaseOnlyAlfa_Excepct38 () throws Exception {
		final float v = calculator.calculateEntropyByNIST (" 123456789012345678901A ");
		Assert.assertEquals (38, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght23_mixCaseSpecial_Excepct45 () throws Exception {
		final float v = calculator.calculateEntropyByNIST (" 123456789012345678901A* ");
		Assert.assertEquals (45, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght24_mixCaseSpecial_Excepct46 () throws Exception {
		final float v = calculator.calculateEntropyByNIST (" 123456789012345678901A*? ");
		Assert.assertEquals (46, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_SameEntropy () throws Exception {
		final float v = calculator.calculateEntropyByNIST (" ^341^)8@#05&*6%%#$7(9!24% ");
		final float vx = calculator.calculateEntropyByNIST (" !111111111111111111111111 ");
		Assert.assertEquals (vx, v, DELTA);
	}

	@Test
	public void testCalculateSecondsToCrack_inDictionaryWord () throws Exception {
		List<String> dic = new ArrayList<String> ();
		dic.add ("brasil");
		dic.add ("romario");
		final StrengthResult r = calculator.calculateStrength ("romario", 20, 300000, dic);
		Assert.assertEquals (r.getReason (), Reason.DICTIONARY_WORD);
		Assert.assertEquals (0.0d, r.getSeconds (), 0.0d);
		Assert.assertEquals (r.getAverageGuesses (), 1.0d, 0.0d);
	}

	@Test
	public void testCalculateSecondsToCrack () throws Exception {
		List<String> dic = new ArrayList<String> ();
		dic.add ("brasil");
		dic.add ("romario");
		final double guessesPerSecond = 3000000000d;
		final StrengthResult r = calculator.calculateStrength ("abc123", 50, guessesPerSecond, dic);
		Assert.assertEquals (r.getReason (), Reason.NORMAL);
		Assert.assertEquals (r.getSeconds (), 375299.96894754133333333333333333d, 0.0d);
		Assert.assertEquals (r.getAverageGuesses (), 1125899906842624d, 0.0d);
	}

}