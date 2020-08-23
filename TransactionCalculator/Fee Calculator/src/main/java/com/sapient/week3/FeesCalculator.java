package com.sapient.week3;

import java.util.*;

public class FeesCalculator {
	
	public static void main(String[] args) {
		List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
		Reader reader = new Reader();
		transactions = reader.readData();
		Calculator calc = new Calculator();
		transactions = calc.calculate(transactions);
		Summary summary = new Summary();
		summary.getSummary(transactions);
	}
}
