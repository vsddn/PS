package com.sapient.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KeyRead_Line2 {
	private ArrayList<Integer> al = new ArrayList<Integer>();
	private int n;
	public void read() {
		System.out.println("Enter the number of elements: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Enter elements: ");
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			al.add(num);
		}
	}
	public void display() {
		for(int i=0;i<n;i++) {
			System.out.println(al.get(i));
		}
	}
	public void sort() {
		Collections.sort(al);
	}
	public void find() {
		int element;
		System.out.println("Enter the element to be searched: ");
		Scanner sc= new Scanner(System.in);
		element = sc.nextInt();
		if(al.contains(element)) {
			System.out.println("The element is present.") ;
		} else {
			System.out.println("Element is not present.");
		}
	}
}
