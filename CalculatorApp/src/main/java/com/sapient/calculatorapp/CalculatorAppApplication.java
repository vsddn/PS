package com.sapient.calculatorapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.sapient.calculatorapp", "com.sapient.calculatorapp.model"}) 
public class CalculatorAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CalculatorAppApplication.class, args);
	}
	
}
