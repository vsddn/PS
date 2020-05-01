package com.weeek4.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class Int_Arr_Process {
	private int[] arr;
	private int size;
	
	//Constructor
	private Int_Arr_Process() {
		arr = new int[10];
		size=10;
	}
	
	//Parameterized constructor
	private Int_Arr_Process(int size) {
		arr= new int[size];
		this.size =size;
	}
	
	//Copy constructor
	public Int_Arr_Process(Int_Arr_Process obj) {
		this.size = obj.arr.length;
		this.arr = new int[size];
		this.arr = obj.arr;
	}
	
	public void addArray(int[] array) {
		size += array.length;
		int[] c = new int[size];
	      int count = 0;
	      
	      for(int i = 0; i < arr.length; i++) { 
	         c[i] = arr[i];
	         count++;
	      } 
	      for(int j = 0; j < array.length;j++) { 
	         c[count++] = array[j];}
	      
	      arr=c;
		
	}
		
	
	public void readArray() {
		System.out.println("Enter the elements of the array: ");
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<size;i++) {
		int num = sc.nextInt();
		arr[i]=num;
		}	
	}
	
	public void displayHorizontally() {
		System.out.println("Horizontal Display");
		for(int i : arr) {
			System.out.print(i+ " ");}
		System.out.println();
	}
		
	public void displayVertically() {
		System.out.println("Vertical Display");
		for(int i : arr) {
			System.out.println(i);}
	}	
	
	public void sortArray() {
        for (int i = 1; i < size; ++i) { 
            int ele = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > ele) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = ele; 
        }
        
	}
	
	public void getBigAndSmallElements() {
		int biggest=Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for(int i: arr) {
			if(i>biggest) biggest=i;
			if(i<smallest) smallest=i;
		}
		System.out.println("Biggest element: "+biggest
				+" Smallest element: "+smallest);
	}
	
	public void getSum() {
		int sum=0;
		for(int i:arr) {
			sum+=i;
		}
		System.out.println("Sum is: "+sum);
	}
	
	public void secondBiggest() {
		sortArray();
		int ele=0;
		Boolean flag=false;
		for(int i=size-2;i>=0;i--) {
			if(arr[i]!=arr[i+1]){ flag=true; ele= arr[i]; break;}
		}
		
		if(flag) {
			System.out.println("Second biggest element: "+ele);
		} else {
			System.out.println("No second biggest element present");
		}
	}
		
	public static void main(String[] args) {
		System.out.println("Enter the number of elements: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Int_Arr_Process obj = new Int_Arr_Process(n);
		obj.readArray();
		Int_Arr_Process obj2 = new Int_Arr_Process(obj);
		System.out.println("obj2");
		obj2.displayHorizontally();
		
		obj.addArray(new int []{1,2,4});
		obj.displayHorizontally();
		obj.displayVertically();
		obj.getBigAndSmallElements();
		obj.secondBiggest();
		obj.getSum();
		obj.sortArray();
		obj.displayHorizontally();
	}
}
