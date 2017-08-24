package com.harish.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@XmlRootElement
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Date createdDate;
	
	private List<Employee> employeeList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	@JsonSerialize(using = DateSerializer.class)
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", createdDate=" + createdDate + "]";
	}

}
