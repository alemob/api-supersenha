package br.com.alexmob.api.supersenha.impl;

import br.com.alexmob.api.supersenha.PasswordStrengthCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordStrengthCalculatorImplTest {

	static final float DELTA = 0.001F;
	PasswordStrengthCalculator calculator;

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
	public void testCalculateEntropyByNIST_Lenght1_Excepct4 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("1 ");
		Assert.assertEquals (4.0, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght8_Excepct20 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("12345678 ");
		Assert.assertEquals (18.0, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght20_Excepct36 () throws Exception {
		final float v = calculator.calculateEntropyByNIST ("12345678901234567890 ");
		Assert.assertEquals (36, v, DELTA);
	}

	@Test
	public void testCalculateEntropyByNIST_Lenght21_Excepct37 () throws Exception {
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
}