package com.example.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.demo.emp.config.EmployeeConfig;


// 將單一配置好的容器注入；避免重複掃描(縱使有也不會怎樣)
@Import({EmployeeConfig.class})
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
