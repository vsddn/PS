package com.learn.ig;

public class Number {

	public Boolean checkPrime(int ele) {
		if(ele<2) return false;
		for(int i=2;i<=Math.sqrt(ele);i++) {
			if(ele%i==0) return false;
		}
		
		return true;
	}
	
	// check if the number is armstrong (for 3 digit numbers)
	public Boolean checkArmstrong(int ele) throws IllegalArgumentException  {
		try {
			
			int count=0,x=ele;
			while(x>0) {
				x=x/10;
				count++;
			}
			System.out.println(count);

			if(count!=3) throw new IllegalArgumentException("Other than 3 digit number...");
		
		else {
			int tmp = ele;   
			int sum=0,r=0;
			while(ele>0)    
			{    
			r=ele%10;    
			sum=sum+(r*r*r);    
			ele=ele/10;    
			}    
			if(tmp==sum)    
			return true;
			}
		
		} finally {
			
		}
		return false;
	}
	
	public Boolean checkPalindrome(int ele) {
	  int tmp = ele;
	  int r;
	  int new_num=0;
	    while (ele != 0) {
	        r = ele % 10;
	        new_num = new_num * 10 + r;
	        ele /= 10;
	    }
	    
	    if (tmp != new_num)
	       return false;
	   
	return true;
	}
	
	
}
