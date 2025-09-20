package com.example.demo.emp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.example.demo.emp")
@EnableTransactionManagement
public class EmployeeConfig {
	

}
