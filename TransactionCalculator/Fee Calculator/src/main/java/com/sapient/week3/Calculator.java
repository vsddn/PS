package com.sapient.week3;

import java.util.*;

public class Calculator {
	private double processingFees;
	private List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
	TransactionFees transactionFees = new TransactionFees();
	
	public List<TransactionPOJO> calculate(List<TransactionPOJO> passedTransactions) {
		transactions = passedTransactions;
		for(TransactionPOJO transaction : transactions ) {
			if(isIntraDayTransaction(transaction)) {
				intraDayTransactions(transaction);
			} else {
				normalTransactions(transaction);
			}
		}
		return transactions;
	}
	
	private boolean isIntraDayTransaction(TransactionPOJO transaction) {
		boolean isIntraDayTransaction = false;
		if (transactions.size() > 0) {
			TransactionPOJO temp = null;
			for (TransactionPOJO localTransaction : transactions) {
				if (localTransaction.getClientId().equals(transaction.getClientId())
						&& localTransaction.getSecurityId().equals(transaction.getSecurityId())
						&& localTransaction.getTransactionDate().equals(transaction.getTransactionDate())) {
					if ((localTransaction.getTransactionType().contentEquals("BUY") 
							&& localTransaction.getTransactionType().contentEquals("SELL"))
							|| (localTransaction.getTransactionType().contentEquals("SELL")
									&& localTransaction.getTransactionType().contentEquals("BUY"))) {
						isIntraDayTransaction = true;
						temp = localTransaction;
						break;
					}
				}
			}

			if (temp != null) {
				transactions.remove(temp);
				temp.setProcessingFees(temp.getProcessingFees()+transactionFees.getFees(temp.getTransactionType()));
				transactions.add(temp);
			}

		} else {
			isIntraDayTransaction = false;
		}
		return isIntraDayTransaction;
	}

	private void intraDayTransactions(TransactionPOJO transaction) {
		int fees = 10;
		transaction.setProcessingFees(processingFees);
	}
	
	private void normalTransactions(TransactionPOJO transaction) {
		if(transaction.getPriorityFlag()=='Y') {
			processingFees = 500;
		} else {
			TransactionFees transactionFees = new TransactionFees();
			processingFees = transactionFees.getFees(transaction.getTransactionType());
		}
		transaction.setProcessingFees(processingFees);
	}
	
}
