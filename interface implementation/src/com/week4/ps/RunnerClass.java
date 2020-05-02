package com.week4.ps;

import java.util.Scanner;

interface Num_Process{
	int cal(int a,int b);
}

public class RunnerClass {

	public static void main(String []args) {
		public static void main(String []args) {
		Num_Process obj[] = new Num_Process[4];
		System.out.println("Enter two numbers: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("Choose the option:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		int choice = sc.nextInt();
		sc.close();
		obj[0] = (a,b)->(a+b);		
		obj[1] = (a,b)->(a-b);	
		obj[2] = (a,b)->(a*b);		
		obj[3] = (a,b)->(a/b);
		
		System.out.println(obj[choice-1].cal(x, y));	
	}

}
