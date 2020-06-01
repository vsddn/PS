package com.learn.ig;

import java.util.Scanner;

// Base Class
public class BasicCalculator {
	protected int a,b;
	
	public void calculator() {
		System.out.println("Enter the 2 numbers: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
	}
	
	public void add() {
		System.out.println(a+b);
	}
}
