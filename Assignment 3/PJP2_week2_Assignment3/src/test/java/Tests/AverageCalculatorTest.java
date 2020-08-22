package Tests;
import java.io.IOException;

import org.apache.commons.logging.impl.AvalonLogger;
import org.junit.*;

import Calculators.Calculator;

public class AverageCalculatorTest {
	Calculator calc;
	String expected;
	String actual;
	@Before
	public void setUp() {
		calc= new Calculator();
		expected="Success";
	}
	
	@Test
	public void checkSuccessfulCalculation() throws IOException {
		actual = calc.calculateAverage();
		Assert.assertEquals(expected, actual);
	}
}
