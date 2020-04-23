package com.sapient.shapes;

import java.math.BigDecimal;

public class Circle {
    private float area;
	public void calculateArea(float radius) {
		area = (float) 3.14 * radius * radius;
		System.out.println("The Area of the Circle is "+area);
	}

}
