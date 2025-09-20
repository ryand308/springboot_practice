package com.example.demo.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.emp.dao.BasicDao;
import com.example.demo.emp.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private BasicDao<Employee, Long> dao;
	
	@Transactional
	public List<Employee> findAllEmployee() {
		
		return dao.find();
	}
}
