package date_time_calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

	private DateTimeCalculator calc;
	@BeforeAll
	public void check() {
		calc= new DateTimeCalculator();
	}
	
	@Test
	public void checkTheAdditionOfNDays() {
		int days=5;
		String expected = "28/10/2020";
		String date = "23/10/2020";
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String actual = calc.addNDays(date1, 3);
		assertEquals(expected, actual);;
	}
	
	@Test
	public void checkTheDayOfTheWeek() {
		String date = "30/08/2020";
		String expected = "Sunday";
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String actual = calc.getDayOfTheDate(date1, 9);
	}

}
