package com.sapient.project2;

public class Runner {

	public static void main(String[] args) {
		
        Command_Line1 obj = new Command_Line1();
        obj.setData();
        obj.calData();
        obj.displayData();
        
        KeyRead_Line2 obj1 = new KeyRead_Line2();
        obj1.read();
        obj1.sort();
        obj1.display();
        obj1.find();
        
        Fig_To_Words obj3 = new Fig_To_Words();
        obj3.figToWords();
	}

}
