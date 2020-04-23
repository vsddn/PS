package com.sapient.shapes;

import java.math.BigDecimal;

public class Triangle {
	private float area;
	public void calculateArea(float side) {
		area = (float) 0.433 * side * side;
		System.out.println("The Area of the Triangle is "+area);
	}

}
