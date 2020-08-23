package com.sapient.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reader {
	String line;
	List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
	public List<TransactionPOJO> readData() {
		try   
		{  
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vijay\\Desktop\\PJP2\\week2solution\\TransactionCalculator\\input.csv"));  
			br.readLine();
            while ((line = br.readLine()) != null) {
            	String[] transaction = line.split(","); 
                String eternalTransactionId = (transaction[0]);
            	String clientId = (transaction[1]);
            	String securityId = transaction[2];
            	String transactionType= transaction[3];
            	Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction[4]);
            	double marketValue = Double.parseDouble(transaction[5]);
            	char priorityFlag = transaction[5].charAt(0);
            	
                transactions.add(new TransactionPOJO(eternalTransactionId,clientId,securityId,transactionType, transactionDate,marketValue,priorityFlag));
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}
}
