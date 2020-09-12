package com.sapient.calculatorapp.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.calculatorapp.model.DateTimeCalculator;
import com.sapient.calculatorapp.model.DatesManager;
import com.sapient.calculatorapp.model.Session;
import com.sapient.calculatorapp.repository.SessionRepository;

@Controller
public class DateTimeRestController {
	@Autowired
	DateTimeCalculator datetTimeCalculator;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	DatesManager datesManager;

	
	Long session_id =(long) 1;
	
	List<Long> allSession;
	
	private String result;
	private String query;
	private String date;
	
	@GetMapping("/")
	public String homePage() {
		session_id = sessionRepository.findSessionId()+1;
		return "Hello there";
	} 
	
	@GetMapping("/addDates")
	public String addDates(@RequestParam Date date1,@RequestParam Date date2,int choice) {
		result = datetTimeCalculator.addTwoDates(date1, date2,choice);
		 date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	@GetMapping("/subtractDates")
	public String subtractDates(@RequestParam Date date1,@RequestParam Date date2,int choice,ModelMap model) {
		result = datetTimeCalculator.subtractTwoDates(date1,date2,choice);
		 date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		
		return result;
	}
	@GetMapping("/addNDays")
	public String addNDays(@RequestParam Date date1, @RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.addNDays(date1,choice,n);
		 date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	
	@GetMapping("/subtractNDays")
	public String subtractNDays(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.subtractNDays(date1,choice,n);
		String date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		
		return result;
	}
	
	@GetMapping("/addNWeeks")
	public String addNWeeks(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.addNWeeks(date1,choice,n);
		query = "Add "+n+" Weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	@GetMapping("/subtractNWeeks")
	public String subtractNWeeks(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.subtractNWeeks(date1,choice,n);
		query = "Subtract "+n+" weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	@GetMapping("/addNMonths")
	public String addNMonths(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.addNMonths(date1,choice,n);
		date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	@GetMapping("/subtractNMonths")
	public String subtractNMonths(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = datetTimeCalculator.subtractNMonths(date1,choice,n);
		date= getDate(date1);
		sessionRepository.save(new Session(session_id,date,result));
		return result;
	}
	
	@GetMapping("/getDay")
	public String getDayOfTheWeek(@RequestParam Date date,@RequestParam int choice,ModelMap model) {
		result = datetTimeCalculator.getDayOfTheDate(date, choice);
		return result;
	}
	
	@GetMapping("/getWeek")
	public String getWeek(@RequestParam Date date,@RequestParam int choice,ModelMap model) {
		result = datetTimeCalculator.getDayOfTheDate(date, choice);
		return result;
	}
	
	@GetMapping("/history")
	public List<Session> showHistory(ModelMap model) {
		List<Session> session = sessionRepository.findAll();
		model.put("session", session);
		return  session;
		
	}
	
	private String getDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	
}

