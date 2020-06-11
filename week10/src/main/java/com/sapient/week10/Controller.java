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
	EmployeeBO e;
	
	@GetMapping("/employees")
	public List<Employee> showEmployees() {
		return e.showEmployees();
	}	
	
	@PutMapping("update/{id}")
	public Employee updateEmployee(@PathVariable int id) {
		return  e.updateEmployee(id);
		
	}
	
	@GetMapping("/employeeId/{id}")
	public Employee showEmployeeById(@PathVariable int id) {
		return e.showEmployeeWithId(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		e.addEmployee(emp);
		return emp;
	}

	@GetMapping("/employeeName/{name}")
	public Employee showEmployeeByName(@PathVariable String name) {
		return e.showEmployeeWithName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		e.deleteEmployee(id);
	}

}