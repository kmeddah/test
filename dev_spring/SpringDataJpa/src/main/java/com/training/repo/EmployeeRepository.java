package com.training.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByNom(String n);
	
	public Page<Employee> findByNom(String n, Pageable pageable);
	
	public List<Employee> findDistinctByRole(String role);
	
	public Employee findByLoginAndPassword(String l, String p);
	
	public Page<Employee> findAll(Pageable pageable);
	
}
