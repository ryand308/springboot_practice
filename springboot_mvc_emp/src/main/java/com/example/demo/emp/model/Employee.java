package com.example.demo.emp.model;

import java.time.LocalDateTime;

public class Employee {

	//@Id primary key	
	private Long empId;
	private String name;
	private String email;
	private double salary;
	private LocalDateTime date;
	
	public Employee() {
		
	}
	
	public Employee(Long empId, String name, String email, double salary, LocalDateTime date) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.date = date;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", salary=" + salary + ", date="
				+ date + "]";
	}
	
	
	
}
