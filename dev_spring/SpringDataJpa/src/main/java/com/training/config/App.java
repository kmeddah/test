package com.training.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.training.model.Employee;
import com.training.service.EmployeeService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class, JPAConfig.class);
		context.refresh();
		
		/*EmployeeService empService = context.getBean(EmployeeService.class);
		
		List<Employee> empList = empService.findAll();
		
		Employee empLP = empService.findByLoginAndPassword("NN","trainingekoura");*/
		
		/*@SuppressWarnings("deprecation")
		Page<Employee> empPage = empService.findAll(new PageRequest(0, 2));
		*/
		
		/*for (Employee employee : empList) {
			System.out.println("Login = " + employee.getLogin() + " Password = " + employee.getPassword());
		}
		
		System.out.println("User nom : " + empLP.getNom());*/

	}

}
