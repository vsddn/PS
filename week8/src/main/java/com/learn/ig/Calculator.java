package com.learn.ig;

import java.util.Scanner;

// The class calculator can be used in place of BasicCalculator (Liskov substitution principle)
public class Calculator extends BasicCalculator {
	
	// It only performs taking input part (Single Responsibility)
	public Calculator() {
		super();
		ArithmeticOperations obj = new ArithmeticOperations();
		ShowMenu show = new ShowMenu();
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch(input) {
		case 1: obj.add(a,b); break;
		case 2: obj.sub(a,b); break;
		case 3: obj.mul(a,b); break;
		case 4: obj.div(a,b); break;
		}
	}
	
}
