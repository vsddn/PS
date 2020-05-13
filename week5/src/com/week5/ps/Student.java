package com.week5.ps;

public class Student {

	public static void main(String[] args) throws StudentNotFound {
		BObject obj = new BObject();
		obj.readStudents(2);
		obj.displayStudents();
		obj.cityWiseSorted();
		obj.nameWiseSorted();
		//obj.studentId(3);
		obj.studentId(2);
		obj.displayCityStudents("florida");

	}

}
