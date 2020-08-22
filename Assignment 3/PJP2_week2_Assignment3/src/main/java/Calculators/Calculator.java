package Calculators;
import java.io.*;
import java.util.*;

import com.opencsv.CSVWriter;

public class Calculator {
	
	private Map<String,Float> mp2= new HashMap<String,Float>();
	public Calculator() {
		mp2.put("INR", (float) 66);
		mp2.put("GBP",(float) 0.67);
		mp2.put("SGD", (float) 1.5);
		mp2.put("HKD",(float) 8);
	}
	
	public String calculateAverage() throws IOException {
		String line;
		Map<String,Float> mp= new TreeMap<String,Float>();
		
		try   
		{  
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vijay\\Desktop\\PJP2\\wee2solution\\Assignment 3\\Input.csv"));  
			br.readLine();
			while ((line = br.readLine()) != null)   
			{  
				String[] record = line.split(",");    
				String city=record[0];
				String country=record[1];
				String gender=record[2];
				String currency=record[3];
				String income = record[4];
				System.out.println(income);
				float amount = Float.parseFloat(record[4]);
				
				if(mp2.containsKey(currency)) {
					amount/=mp2.get(currency);
				}
				
				if(country.equals(" "))
					{
				    	if(mp.containsKey(city+gender))
				    	  {
				    		float amnt=mp.get(city+gender);
				    		amnt+=amount;
				    		mp.put(city+gender,amnt);
				    	  }
				    	else{
				    		mp.put(city+gender,amount);
				    	 }
					}
				
				else{
					if(mp.containsKey(country+gender))
			    	  {
			    		float amnt=mp.get(country+gender);
			    		amnt=amnt+amount;
			    		mp.put(country+gender,amnt);
			    	  }
			    	else{
			    		mp.put(country+gender,amount);
			    	 }
				}  
				
			}
		}   
		catch (IOException e)   
		{  	e.getMessage();
			//e.printStackTrace();  
		}    
		
		// Display the data of Map
        for (Map.Entry<String,Float> entry : mp.entrySet())  
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        
        
		try {
			FileWriter outputfile = new FileWriter("C:\\Users\\vijay\\Desktop\\PJP2\\wee2solution\\Assignment 3\\Output.csv"); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        
	        String[] row = {"City/Country","Gender","Average Income" }; 
	        writer.writeNext(row); 
	        
	        List<String[]> data = new ArrayList<String[]>(); 
	        
	        for (Map.Entry<String,Float> entry : mp.entrySet())  {
	            String key= entry.getKey();
	            float value= entry.getValue();
	            int len=key.length();
	            char gender = key.charAt(len-1);
	            key=key.substring(0,len-1);
	            row[0]=key; row[1]=String.valueOf(gender); row[2]=Float.toString(value);
	            //System.out.println(row[0]+" "+row[1]+" "+row[2]);
	            data.add(new String[] {row[0],row[1],row[2]});
	        }
	        
	        writer.writeAll(data); 
	        writer.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		return "Success";
	}
}
