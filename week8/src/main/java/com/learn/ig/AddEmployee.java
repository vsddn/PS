package com.learn.ig;

import java.util.*;

public class AddEmployee {
			
			private List<Employee> list = new ArrayList();
			
			public void addEmployee(Employee emp) {
				list.add(emp);
			}
			
			public Employee getEmployee(int id) {
				for(Employee emp : list) {
					if(emp.getId() == id) {
						return emp;
					}
				}
				return null;
			}
			
}
