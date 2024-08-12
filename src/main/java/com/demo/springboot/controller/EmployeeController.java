package com.demo.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.service.EmployeeService;
import com.example.SpringBoot1.Employee;

@RestController
@RequestMapping("/api/emp")

public class EmployeeController {
		
	

	        private EmployeeService ser;
	        @GetMapping
	        public List<Employee> getAllEmployees(){
	            return ser.getAllEmployees();
	            
	            
	        }
	        @GetMapping("/{id}")
	        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	        {
	            Optional<Employee> employee=ser.getEmployeeById(id);
	            return employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	        }
	        
	        @PostMapping
	        public Employee createEmployee(@RequestBody Employee employee)
	        {
	            return ser.saveEmployee(employee);
	        }
	        
	        @PutMapping("/{id}")
	        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
	        {
	            Optional<Employee> optionalEmployee=ser.getEmployeeById(id);
	            if(optionalEmployee.isPresent())
	            {
	                Employee employee=optionalEmployee.get();
	                employee.setName(employeeDetails.getName());
	                employee.setSalary(employeeDetails.getSalary());
	                employee.setSkill(employeeDetails.getSkill());
	                return ResponseEntity.ok(ser.updateEmployee(employee));
	            }
	            else
	            {
	                return ResponseEntity.notFound().build();
	            }
	        }
	}
