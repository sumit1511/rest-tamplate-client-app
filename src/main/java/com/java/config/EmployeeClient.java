package com.java.config;

import java.util.List;

import com.model.Employee;

public interface EmployeeClient {
	List<Employee> getAllEmployee();

	Employee addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Long id);
}
