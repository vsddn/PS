package com.sapient.calculatorapp.historymanager;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class History implements Serializable {
	private String firstDate;
	private String secondDate;
	private String choice;
	private String result;
	private String N;
	private DateFormat dateFormat;
	private static final long serialVersionUID = 1L;
	
	public History() {
		firstDate = null;
		secondDate = null;
		choice = null;
		result = null;
		N = null;
	}
	
	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public String getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(String secondDate) {
		this.secondDate = secondDate;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	private void setBasic(Date date, int choice) {
		dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	    this.firstDate = dateFormat.format(date);
	    this.choice = Integer.toString(choice);
	}
	
	public History(Date date1, Date date2, int choice, Date result) {
		setBasic(date1,choice);
		dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	    secondDate = dateFormat.format(date2);
	    this.result = dateFormat.format(result);
	}
	
	public History(Date date1, Date date2, int choice, String result) {
		setBasic(date1,choice);
	    secondDate = dateFormat.format(date2);
	    this.result=result;
	}

	public History(Date date, int N, int choice, String result) {
		setBasic(date,choice);
		this.N = Integer.toString(N);
		this.result=result;
	}

	public History(Date date, int choice, int result) {
		setBasic(date,choice);
		this.result = Integer.toString(result);
	}
	
	public History(Date date, int choice, String result) {
		setBasic(date,choice);
		this.result = result;
	}
	
	
}
