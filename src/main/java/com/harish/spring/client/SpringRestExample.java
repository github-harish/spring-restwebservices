package com.harish.spring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.harish.spring.controller.EmpRestURIConstants;
import com.harish.spring.model.Employee;

public class SpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/springmvc-restservice";

	public static void main(String args[]) {
		testGetDummyEmployee();
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		// testGetEmployee();
		System.out.println("*****");
		// testGetAllEmployee();
	}

	public static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + EmpRestURIConstants.DUMMY_EMP, Employee.class);
		System.out.println(emp.toString());
	}

	public static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("Pankaj Kumar");
		Employee response = restTemplate.postForObject(SERVER_URI + EmpRestURIConstants.CREATE_EMP, emp,
				Employee.class);
		System.out.println(response.toString());
	}

}
