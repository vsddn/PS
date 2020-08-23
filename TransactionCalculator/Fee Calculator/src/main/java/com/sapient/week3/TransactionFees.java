package com.sapient.week3;

import java.util.*;

public class TransactionFees {
	private Map<String,Integer> type = new HashMap<String,Integer>();
	public TransactionFees() {
		type.put("BUY",1); 
		type.put("SELL",2); 
		type.put("DEPOSIT",3); 
		type.put("WITHDRAW",4); 
	}
	
	public int getFees(String transactionType) {
		int transaction = type.get(transactionType);
		
		if(transaction == 1) return 50;
		else if( transaction==2) return 100;
		else if(transaction==3) return 50;
		return 100;
		
	}

	
}
