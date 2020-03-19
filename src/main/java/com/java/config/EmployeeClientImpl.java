package com.java.config;

import java.util.Arrays;
import java.util.List;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class EmployeeClientImpl implements EmployeeClient {

	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "http://localhost:8080/crud-jdbc-template-app/employees";

	public List<Employee> getAllEmployee() {
		ResponseEntity<Employee[]> response = restTemplate.getForEntity(ROOT_URI, Employee[].class);
		return Arrays.asList(response.getBody());

	}

	public Employee addEmployee(Employee employee) {
		ResponseEntity<Employee> response = restTemplate.postForEntity(ROOT_URI, employee, Employee.class);
		return response.getBody();
	}

	public void updateEmployee(Employee employee) {
		restTemplate.put(ROOT_URI, employee);
	}

	public void deleteEmployee(Long id) {
		restTemplate.delete(ROOT_URI + id);

	}
}
