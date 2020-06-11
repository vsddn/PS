package com.sapient.week10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("home")
	public String welcome() {
		return "home";
	} 
	
}
