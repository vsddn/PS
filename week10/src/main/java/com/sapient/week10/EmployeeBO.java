package com.sapient.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class EmployeeBO {
	
		static List<Employee> list = new ArrayList<Employee>();
		static {
			list.add(new Employee(1,"David","New York"));
			list.add(new Employee(2,"Anya","Mexico"));
			list.add(new Employee(3,"Amit","London"));
			list.add(new Employee(4,"Ravi","India"));
		}
		
		public void addEmployee(Employee e) {
			list.add(e);
		}
		
		public int addEmployee(int id, String name, String city)
		{
			list.add(new Employee(id,name,city));
			return id;
		}
		
		public Employee updateEmployee(int id) {
			for(Employee e:list)
			{
				if(e.getId()==id)
				{
					e.setName("New Name");
					e.setCity("New City");
					return e;
					
				}
			}
			return null;
		}
		

		public void deleteEmployee(int id) {
			Iterator<Employee> i = list.iterator();
			while(i.hasNext()) 
			{
				if(i.next().id ==id)
				{
					i.remove();
				}
			}
		}
		
		public Employee showEmployeeWithId(int id) {
			for(Employee e: list)
			{
				if(e.id==id)
					return e;
			}
			return null;
		}
		
		
		public List<Employee> showEmployees(){
			return list;
		}

		public Employee showEmployeeWithName(String name) {
			for(Employee obj:list) 
			{
				if(obj.getName().equals(name))
				{
					return obj;
				}
			}
			return null;
		}
		
}
