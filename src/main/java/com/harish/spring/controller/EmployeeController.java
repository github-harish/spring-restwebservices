package com.harish.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harish.spring.model.Employee;

@Controller
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();

	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		log.info("Start getDummyEmployee");

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Rajeev");
		emp.setCreatedDate(new Date());
		empMap.put(1, emp);

		return emp;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable("id") int id) {
		log.info("Start getEmployee.");
		Employee emp = empMap.get(id);
		return emp;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getAllEmployee() {
		log.info("Start getAllEmployees.");
		List<Employee> empList = new ArrayList<>();
		Set<Integer> keySets = empMap.keySet();
		Iterator<Integer> it = keySets.iterator();
		while (it.hasNext()) {
			Employee emp = empMap.get(it.next());
			empList.add(emp);
		}
		Employee emp1 = new Employee();
		emp1.setEmployeeList(empList);
		return emp1;
	}

	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		log.info("Start createEmployee.");
		emp.setCreatedDate(new Date());

		empMap.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		log.info("Start deleteEmployee.");
		Employee emp = empMap.get(empId);
		empMap.remove(empId);
		return emp;
	}
}
