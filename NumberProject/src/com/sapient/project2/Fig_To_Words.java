package com.sapient.project2;

import java.util.Scanner;

public class Fig_To_Words {
        
	 private static final String[] specialNames = {
		        "",
		        " thousand",
		        " million",
		        " billion",
		        " trillion",
		        " quadrillion",
		        " quintillion"
		    };
		    
		    private static final String[] tensNames = {
		        "",
		        " ten",
		        " twenty",
		        " thirty",
		        " forty",
		        " fifty",
		        " sixty",
		        " seventy",
		        " eighty",
		        " ninety"
		    };
		    
		    private static final String[] numNames = {
		        "",
		        " one",
		        " two",
		        " three",
		        " four",
		        " five",
		        " six",
		        " seven",
		        " eight",
		        " nine",
		        " ten",
		        " eleven",
		        " twelve",
		        " thirteen",
		        " fourteen",
		        " fifteen",
		        " sixteen",
		        " seventeen",
		        " eighteen",
		        " nineteen"
		    };
		    
		    private String convertLessThanOneThousand(int number) {
		        String current;
		        
		        if (number % 100 < 20){
		            current = numNames[number % 100];
		            number /= 100;
		        }
		        else {
		            current = numNames[number % 10];
		            number /= 10;
		            
		            current = tensNames[number % 10] + current;
		            number /= 10;
		        }
		        if (number == 0) return current;
		        return numNames[number] + " hundred" + current;
		    }
        		    
		    
        		    public void figToWords() {
        	        	 int number;
        	        	 System.out.println("Enter the number: ");
        	        	 Scanner sc = new Scanner(System.in);
        	        	 number = sc.nextInt();

        		        if (number == 0) { System.out.println("Zero"); }
        		        
        		        String prefix = "";
        		        
        		        if (number < 0) {
        		            number = -number;
        		            prefix = "negative";
        		        }
        		        
        		        String current = "";
        		        int place = 0;
        		        
        		        do {
        		            int n = number % 1000;
        		            if (n != 0){
        		                String s = convertLessThanOneThousand(n);
        		                current = s + specialNames[place] + current;
        		            }
        		            place++;
        		            number /= 1000;
        		        } while (number > 0);
        		        System.out.println((prefix + current).trim() + " only" );       		  
        		    }
        		    
}
