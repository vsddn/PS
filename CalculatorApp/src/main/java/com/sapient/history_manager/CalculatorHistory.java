package com.sapient.history_manager;

import java.util.*;

import com.sapient.date_time_calculator.DatesManager;

public class CalculatorHistory {
	private ArrayList<History> historyList; 
	private Importer importer;
	private Exporter exporter;
	
	public CalculatorHistory() {
		historyList = new ArrayList<History>();
		importer = new Importer();
		exporter = new Exporter();
	}
	
	public void addHistory(History history) {
		historyList.add(history);
	}
	
	public void displayHistory(ArrayList<History> currHistoryList) {
		int counter=1;
		for(History history: currHistoryList) {
			System.out.println("Record "+counter);
			System.out.print("Intial date: "+ history.getFirstDate()+", ");
			System.out.print("Choice entered: "+ history.getChoice()+", ");
			if(history.getSecondDate()!=null)
			System.out.print("Second date: "+ history.getFirstDate()+", ");
			if(history.getN()!=null)
			System.out.print("N: "+ history.getN()+", ");
			System.out.println("Result: "+ history.getResult());
			System.out.println("========================================================================");
			if(counter==100) break;
			counter++;
		}
	}
	
	public void showCurrentHistory() {
		displayHistory(historyList);
	}
	
	public void showOldHistory() {
		ArrayList<History> oldHistoryList = importer.importHistory();
		displayHistory(oldHistoryList);
	}

	public void saveHistory() {
		exporter.exportHistory(historyList);
	}
	
}
