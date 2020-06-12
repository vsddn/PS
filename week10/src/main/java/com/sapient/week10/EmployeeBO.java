package com.sapient.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class EmployeeBO {
	
		static List<Employee> employeeList = new ArrayList<Employee>();
		static {
			employeeList.add(new Employee(1,"David","New York"));
			employeeList.add(new Employee(2,"Anya","Mexico"));
			employeeList.add(new Employee(3,"Amit","London"));
			employeeList.add(new Employee(4,"Ravi","India"));
		}
		
		public void addEmployee(Employee e) {
			employeeList.add(e);
		}
		
		public int addEmployee(int id, String name, String city)
		{
			employeeList.add(new Employee(id,name,city));
			return id;
		}
		
		public Employee updateEmployee(int id) {
			for(Employee e:employeeList)
			{
				if(e.getId()==id)
				{
					e.setName("Cristiano");
					e.setCity("Portugal");
					return e;
				}
			}
			return null;
		}
		
		public String deleteEmployee(int id) {
			Iterator<Employee> itr = employeeList.iterator();
			while(itr.hasNext()) 
			{
				Employee obj = itr.next();
				if(obj.getId() ==id)
				{  
					itr.remove();
					return "Deletion Successful";
				}
			}
			return "Deletion Failed";
		}
		
		public Employee showEmployeeWithId(int id) {
			for(Employee emp: employeeList)
			{
				if(emp.getId()==id)
					return emp;
			}
			return null;
		}
		
		
		public List<Employee> showEmployees(){
			return employeeList;
		}

		public Employee showEmployeeWithName(String name) {
			for(Employee obj:employeeList) 
			{
				if(obj.getName().equals(name))
				{
					return obj;
				}
			}
			return null;
		}
		
}
