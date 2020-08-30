package date_time_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import date_time_calculator.DateTimeCalculator;
import date_time_calculator.DatesManager;

public class CalculatorTest {
	    private static DateTimeCalculator calc;
		
	    @BeforeAll
	    public static void setUp() {
	    	calc = new DateTimeCalculator();
	    }
	    
		@Test
		@DisplayName("Addition of days")
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
			String actual = calc.getAdditionOfNDays(date1, 5);
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("Week Day")
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
			assertTrue(expected.equals(actual));
		}
		
		@Test
		@DisplayName("Weeks added")
		public void checkTheWeekOfTheDate() {
			String date = "8/01/2020";
			int expected = 2;
			Date date1 = null;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int actual = calc.getWeek(date1);
			assertEquals(expected,(actual));
		}
		
}
