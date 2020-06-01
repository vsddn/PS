package com.test.ig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.learn.ig.AddEmployee;
import com.learn.ig.Employee;

public class AddEmployeeTest {
	
	AddEmployee emp=null;
	
	@Before
	public void setup() {
		emp = new AddEmployee();
		emp.addEmployee(new Employee(101,"David","Mexico"));
	}

	@Test
	public void showEmployeeTest() {
		String expected = "David";
		String actual  = (emp.getEmployee(101)).getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shoulReturnNull() {
		Employee actual  = (emp.getEmployee(102));
		assertEquals(null, actual);
	}

}
