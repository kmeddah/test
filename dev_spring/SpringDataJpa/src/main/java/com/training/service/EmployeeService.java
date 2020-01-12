package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.training.model.Employee;
import com.training.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void createOrUpdateEmployee(Employee emp) {
		this.employeeRepository.save(emp);
	}
	
	public void deleteUser(Employee emp) {
		this.employeeRepository.delete(emp);
	}
	
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
	
	public Employee findByLoginAndPassword(String login, String password) {
		return this.employeeRepository.findByLoginAndPassword(login, password);
	}
	
	public Page<Employee> findAll(Pageable pageable){
		return this.employeeRepository.findAll(pageable);
	};
}
//TODO : 
// Liste 20 items per page