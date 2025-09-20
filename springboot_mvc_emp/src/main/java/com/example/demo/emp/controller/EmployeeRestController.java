package com.example.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.emp.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService serivce;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring";
	}
	
	@GetMapping("/test")
	public List<?> getTest() {
		// 測試spring boot web 自動 json 序列化
		List<String> list = List.of("kk", "aa", "dd");
		return list; 
	}
	
	@GetMapping("/list")
	public List<?> getFindAll() {
		
		return serivce.findAllEmployee();
	}
}
