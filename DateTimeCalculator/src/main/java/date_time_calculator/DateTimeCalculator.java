package date_time_calculator;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.*;

import history_manager.CalculatorHistory;
import history_manager.History;

public class DateTimeCalculator {
	private Calendar calendar;
	public static CalculatorHistory calculatorHistory;
	private Scanner sc;
	private String[] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	
	
	public DateTimeCalculator() {
		calendar = Calendar.getInstance();
		calculatorHistory = new CalculatorHistory();
		sc = new Scanner(System.in);
	}
	
	// Add two dates
	public void addTwoDates(Date date1,Date date2,int choice) {
		Date result = new Date(date1.getTime()+date2.getTime());
		System.out.println("New date after adding given 2 dates: ");
		System.out.println(result);
		calculatorHistory.addHistory(new History(date1,date2,choice,result));
	}
	
	
	// Subtract two dates
	public void subtractTwoDates(Date date1,Date date2,int choice) {
		calendar.setTime(date1);
		Calendar m_calendar=Calendar.getInstance();
		
		long years = Math.abs(m_calendar.get(Calendar.YEAR)- calendar.get(Calendar.YEAR));
		long months = Math.abs(m_calendar.get(Calendar.MONTH)-calendar.get(Calendar.MONTH));
		long weeks = years*52;
		long days = years*365;
	
		String result = (years+" years, "+months+" months, "+weeks+" weeks, "+days+" days.");
		System.out.println(result);
		calculatorHistory.addHistory(new History(date1,date2,choice,result));
		}
	
	// Add days to a date
	public void addNDays(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of days you want to add: ");
		int days = sc.nextInt();
		calendar.add(Calendar.DATE, days);
		String result = getDate(calendar);
        System.out.println("Date after adding "+days+" days : " + result);
        calculatorHistory.addHistory(new History(date,days,choice,result));
		}
		
	// Subtract days from date
	public void subtractNDays(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of days you want to add: ");
		int days = sc.nextInt();
		calendar.add(Calendar.DATE, -days);
		String result = getDate(calendar);
        System.out.println("Date after adding "+days+" days : " + result);
        calculatorHistory.addHistory(new History(date,days,choice,result));
		}
	
	// Subtract weeks from a date
	public void subtractNWeeks(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of weeks you want to subtract: ");
		int weeks = sc.nextInt();
		calendar.add(Calendar.WEEK_OF_YEAR, -weeks);
		String result = getDate(calendar);
        System.out.println("Date after subtracting "+weeks+" weeks : " + result);
        calculatorHistory.addHistory(new History(date,weeks,choice,result));
		}
		
	// Add weeks to a date
	public void addNWeeks(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of weeks you want to add: ");
		int weeks = sc.nextInt();
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		String result = getDate(calendar);
        System.out.println("Date after adding "+weeks+" weeks : " + result);
        calculatorHistory.addHistory(new History(date,weeks,choice,result));
		}
	
	// Subtract Months from a date
	public void subtractNMonths(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of months you want to subtract: ");
		int months = sc.nextInt();
		calendar.add(Calendar.MONTH, -months);
		String result = getDate(calendar);
        System.out.println("Date after subtracting "+months+" months : " + result);
        calculatorHistory.addHistory(new History(date,months,choice,result));
	}
	
	// Add months to a date
	public void addNMonths(Date date,int choice) {
		calendar.setTime(date);
		System.out.println("Enter the number of months you want to add: ");
		int months = sc.nextInt();
		calendar.add(Calendar.MONTH, months);
		String result = getDate(calendar);
        System.out.println("Date after adding "+months+" months : " + result);
        calculatorHistory.addHistory(new History(date,months,choice,result));
	}
	
	// Get day of the date
	public void getDayOfTheDate(Date date,int choice) {
		calendar.setTime(date);
		String result = weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
		System.out.println("The day of the week is: "+result);
		calculatorHistory.addHistory(new History(date,choice,result));
	}
	
	// Get week of the date
	public void getWeekOfTheDate(Date date,int choice) {
		calendar.setTime(date);
		int result = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Week number is: "+result);
		calculatorHistory.addHistory(new History(date,choice,result));
	}
	
	private String getDate(Calendar cal){
        return "" + cal.get(Calendar.DATE) +"/" +
                (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
	}

	public void showCurrentHistory() {
		calculatorHistory.showCurrentHistory();
	}
	
	public void showOldHistory() {
		calculatorHistory.showOldHistory();
	}

	public void saveHistory() {
		calculatorHistory.saveHistory();
	}
	
}
