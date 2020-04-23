package com.sapient.shapes;

import java.math.BigDecimal;

public class Shapes {
	private float numberOfSides;
	
	public void calculateShapeArea(int numberOfSides,float side) {
		if(numberOfSides==1) {
			Circle obj = new Circle();
			obj.calculateArea(side);
		} else if(numberOfSides==3) {
			Triangle obj = new Triangle();
			obj.calculateArea(side);
		} else if(numberOfSides==4){
			Square obj = new Square();
			obj.calculateArea(side);
		} else {
			System.out.println("No Shapes Present");
		}
	}
	public static void main(String[] args) {
		 {  int numberOfSides = 5;
		    int side =15 ;
			Shapes obj = new Shapes();
			obj.calculateShapeArea(numberOfSides,side);
		}

	}

}
