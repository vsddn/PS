package com.sapient.calculatorapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DatesManager {
	private Date firstDate;
	private Date secondDate;
	private String strFirstDate;
	private String strSecondDate;
	private Scanner sc;
	
	public DatesManager() {
		sc = new Scanner(System.in);
	}
	
	public Date getFirstDate() {
		return firstDate;
	}
	
	public Date getSecondDate() {
		return secondDate;
	}
	
	public void setFirstDate() {
		System.out.println("Please insert the date(dd/MM/yyyy) on which you want to perform operations: ");
		strFirstDate = sc.next();
	    try {
			firstDate=new SimpleDateFormat("dd/MM/yyyy").parse(strFirstDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}
	
	public void setSecondDate() {
		System.out.println("Please insert the second date(dd/MM/yyyy): ");
		strSecondDate = sc.next();
	    try {
			secondDate=new SimpleDateFormat("dd/MM/yyyy").parse(strSecondDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}
}
