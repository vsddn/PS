package com.sapient.week10;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sapient.week10.Week10Application;

public class SpringBootJspApplication extends SpringBootServletInitializer {

	public SpringBootJspApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		return application.sources(Week10Application.class);
		
	}

}