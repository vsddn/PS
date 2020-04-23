package com.sapient.shapes;

import java.math.BigDecimal;

public class Square {
	private float area;
	public void calculateArea(float side) {
		area = (float) side*side;
		System.out.println("The Area of the Sqaure is "+area);
	}
}
