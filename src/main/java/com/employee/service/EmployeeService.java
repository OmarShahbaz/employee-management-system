package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee); //done
	void deleteEmployee(long id); //done
	Employee updateEmployee(Employee employee,long id); //done
	List<Employee> getAllEmployees(); //done
	Employee getEmployeeById(long id); //done
}
