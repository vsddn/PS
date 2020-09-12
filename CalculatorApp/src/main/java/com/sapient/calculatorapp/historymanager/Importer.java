package com.sapient.calculatorapp.historymanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Importer {
	ArrayList<History> importHistory(){
		String filename = "CalculatorHistory.ser";
		
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(file);
			ArrayList<History> historyList=new ArrayList<History>();
			historyList = (ArrayList<History>) ois.readObject();
			ois.close();
			file.close();
			return historyList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	return null;
	}
}