package com.sapient.project2;

import java.util.ArrayList;
import java.util.Scanner;

public class Command_Line1 {
	private int n,sum=0,biggest=Integer.MIN_VALUE,smallest=Integer.MAX_VALUE;
	private float avg=0;
	private ArrayList<Integer> al = new ArrayList<Integer>();
	
	public void calData() {
		for(int i=0;i<al.size();i++) {
			int num=al.get(i);
			sum+=num;
			if(num>biggest) biggest=num;
			if(num<smallest) smallest=num;
		}
	    avg = (float)sum/n;
	}

	public void setData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		n = sc.nextInt();
		
		System.out.println("Enter "+n+" numbers: ");
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			al.add(num);
		}
	}
	
	public void displayData() {
		System.out.println("The sum is: "+sum+"\nThe average is: "+avg);
		System.out.println("The smallest number is: "+smallest+"\nThe biggest number is: "+biggest);
	}
	
}
