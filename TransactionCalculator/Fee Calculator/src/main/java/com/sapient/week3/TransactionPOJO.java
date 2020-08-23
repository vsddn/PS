package com.sapient.week3;

import java.util.Date;

public class TransactionPOJO {
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private double marketValue;
	private char priorityFlag;
	private double processingFees;
	
	public TransactionPOJO(String externalTransactionId, String clientId, String securityId, String transactionType,
			Date transactionDate, double marketValue, char priorityFlag) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public String getSecurityId() {
		return securityId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public double getMarketValue() {
		return marketValue;
	}
	
	public char getPriorityFlag() {
		return priorityFlag;
	}
	
	public double getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(double processingFees) {
		this.processingFees = processingFees;
	}
	
	
}
