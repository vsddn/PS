package com.sapient.CalculatorApp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import date_time_calculator.DateTimeCalculator;
import date_time_calculator.DatesManager;
import date_time_calculator.Session;
import repository.SessionRepository;

@RestController
@RequestMapping("/api")
public class DateTimeRestController {
	@Autowired
	DateTimeCalculator calc;
	@Autowired
	SessionRepository sessionRepository;

	Long session_id =(long) 1;
	
	List<Long> allSession;
	
	private String result;
	private String query;
	
	@GetMapping("/")
	public String homePage() {
		session_id = sessionRepository.findSessionId()+1;
		return "hello user";
	} 
	
	@GetMapping("/addDates")
	public String addDates(@RequestParam Date date1,@RequestParam Date date2,int choice) {
		result = calc.addTwoDates(date1, date2,choice);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/subtractDates")
	public String subtractDates(@RequestParam Date date1,@RequestParam Date date2,int choice,ModelMap model) {
		result = calc.subtractTwoDates(date1,date2,choice);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return result;
	}
	@GetMapping("/addNDays")
	public String addNDays(@RequestParam Date date1, @RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.addNDays(date1,choice,n);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	
	@GetMapping("/subtractNDays")
	public String subtractNDays(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.subtractNDays(date1,choice,n);
		
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return result;
	}
	
	@GetMapping("/addNWeeks")
	public String addNWeeks(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.addNWeeks(date1,choice,n);
		query = "Add "+n+" Weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return "result.jsp";
	}
	
	@GetMapping("/subtractNWeeks")
	public String subtractNWeeks(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.subtractNWeeks(date1,choice,n);
		query = "Subtract "+n+" weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return "result.jsp";
	}
	
	@GetMapping("/addNMonths")
	public String addNMonths(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.addNMonths(date1,choice,n);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/subtractNMonths")
	public String subtractNMonths(@RequestParam Date date1,@RequestParam int choice, @RequestParam int n, ModelMap model) {
		result = calc.subtractNMonths(date1,choice,n);
		//sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/getDay")
	public String getDayOfTheWeek(@RequestParam Date date,@RequestParam int choice,ModelMap model) {
		result = calc.getDayOfTheDate(date, choice);
		return result;
	}
	
	@GetMapping("/getWeek")
	public String getWeek(@RequestParam Date date,@RequestParam int choice,ModelMap model) {
		result = calc.getDayOfTheDate(date, choice);
		return result;
	}
	
	@GetMapping("/history")
	public List<Session> showHistory(ModelMap model) {
		List<Session> session = sessionRepository.findAll();
		model.put("session", session);
		return  session;
		
	}
}
