package com.sapient.week3;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import com.opencsv.CSVWriter;

public class Summary {
	private List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
	public void getSummary(List<TransactionPOJO> passedTransactions) {
        transactions.sort(Comparator.comparing(TransactionPOJO :: getClientId)
                .thenComparing(TransactionPOJO::getTransactionType)
                .thenComparing(TransactionPOJO::getTransactionDate)
                .thenComparing(TransactionPOJO::getPriorityFlag));
        
        transactions= passedTransactions;
        System.out.println("Client Id Transaction Type  Transaction Date  Priority  Processing Fee");
        for (TransactionPOJO transaction : transactions) {
            System.out.println(transaction.getClientId() + "\t" + transaction.getTransactionType() + "\t" +
                    transaction.getTransactionDate() + "\t" + transaction.getPriorityFlag() + "\t" +
                    transaction.getProcessingFees() + "\t");
        }
	}
}
