package com.sapient.week10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	EmployeeBO emp;
	
	@GetMapping("/employees")
	public List<Employee> showEmployees() {
		return emp.showEmployees();
	}	
	
	@GetMapping("/employeeId/{id}")
	public Employee showEmployeeById(@PathVariable int id) {
		return emp.showEmployeeWithId(id);
	}
	
	@GetMapping("/employeeName/{name}")
	public Employee showEmployeeByName(@PathVariable String name) {
		return emp.showEmployeeWithName(name);
	}
	
	@PostMapping(value="/add")
	public EmployeeBO addEmployee() {
		emp.addEmployee(10,"Veronica","Reeva");
		return emp;
	}
	
	@DeleteMapping(value="/delete/{id}" )
	public String deleteEmployee(@PathVariable int id) {
		return emp.deleteEmployee(id);
	}

	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable int id) {
		return  emp.updateEmployee(id);
		
	}
}