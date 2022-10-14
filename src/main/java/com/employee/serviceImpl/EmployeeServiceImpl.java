package com.employee.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(()-> 
										new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(() -> 
												new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSalary(employee.getSalary());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(()->
												new ResourceNotFoundException("Employee", "id", id));
	}
	
	

}
