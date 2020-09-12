package com.sapient.model;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Component;

import com.sapient.history_manager.CalculatorHistory;
import com.sapient.history_manager.History;

@Component
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
	public String addTwoDates(Date date1,Date date2,int choice) {
		Date result = new Date(date1.getTime()+date2.getTime());
		String ret= "New date after adding given 2 dates: "+result;
		calculatorHistory.addHistory(new History(date1,date2,choice,result));
		return ret;
	}
	
	
	// Subtract two dates
	public String subtractTwoDates(Date date1,Date date2,int choice) {
		calendar.setTime(date1);
		Calendar m_calendar=Calendar.getInstance();
		
		long years = Math.abs(m_calendar.get(Calendar.YEAR)- calendar.get(Calendar.YEAR));
		long months = Math.abs(m_calendar.get(Calendar.MONTH)-calendar.get(Calendar.MONTH));
		long weeks = years*52;
		long days = years*365;
	
		String result = (years+" years, "+months+" months, "+weeks+" weeks, "+days+" days.");
		calculatorHistory.addHistory(new History(date1,date2,choice,result));
		return result;
		}
	
	// Add days to a date
	public String addNDays(Date date,int choice,int days) {
		String result = getAdditionOfNDays(date,days);
		String ret = ("Date after adding "+days+" days : " + result);
		calculatorHistory.addHistory(new History(date,days,choice,result));
		return ret;
	}
		
	public String getAdditionOfNDays(Date date,int days) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		String result = getDate(calendar);
        return result;
	}
	
	// Subtract days from date
	public String subtractNDays(Date date,int choice,int days) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -days);
		String result = getDate(calendar);
        String ret = ("Date after adding "+days+" days : " + result);
        calculatorHistory.addHistory(new History(date,days,choice,result));
        return ret;
	}
	
	// Subtract weeks from a date
	public String subtractNWeeks(Date date,int choice,int weeks) {
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_YEAR, -weeks);
		String result = getDate(calendar);
        String ret = ("Date after subtracting "+weeks+" weeks : " + result);
        calculatorHistory.addHistory(new History(date,weeks,choice,result));
        return ret;
		}
		
	// Add weeks to a date
	public String addNWeeks(Date date,int choice,int weeks) {
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		String result = getDate(calendar);
        String ret = ("Date after adding "+weeks+" weeks : " + result);
        calculatorHistory.addHistory(new History(date,weeks,choice,result));
        return ret;
		}
	
	// Subtract Months from a date
	public String subtractNMonths(Date date,int choice,int months) {
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -months);
		String result = getDate(calendar);
        String ret = ("Date after subtracting "+months+" months : " + result);
        calculatorHistory.addHistory(new History(date,months,choice,result));
        return ret;
	}
	
	// Add months to a date
	public String addNMonths(Date date,int choice,int months) {
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		String result = getDate(calendar);
        String ret = ("Date after adding "+months+" months : " + result);
        calculatorHistory.addHistory(new History(date,months,choice,result));
        return ret;
	}
	
	// Get day of the date
	public String getDayOfTheDate(Date date,int choice) {
		calendar.setTime(date);
		String result = weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
		System.out.println("The day of the week is: "+result);
		calculatorHistory.addHistory(new History(date,choice,result));
		return result;
	}
	
	// Get week of the date
	public String getWeekOfTheDate(Date date,int choice) {
		int result = getWeek(date);
		String ret = ("Week number is: "+result);
		calculatorHistory.addHistory(new History(date,choice,result));
		return ret;
	}
	
	public int getWeek(Date date) {
		calendar.setTime(date);
		int result = calendar.get(Calendar.WEEK_OF_YEAR);
		return result;
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
