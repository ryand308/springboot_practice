package com.example.demo.emp.sql;

public interface EmployeeSql {
	
	String CREATE_EMPLOYEE = "CREATE TABLE if not exists `company`.`employees` ( "
						   + " emp_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT \'員工編號\',"
						   + " `name` VARCHAR(20) NOT NULL COMMENT \'姓名\',"
						   + " email VARCHAR(50) NOT NULL COMMENT \'電子郵件\',"
						   + " salary DOUBLE COMMENT \'薪資\',"
						   + " date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT \'建立日期\'"
						   + " ) COMMENT=\'員工資料表\'";
	
	// regular expression for query language
	String GENERIC_ADD = "INSERT INTO `company`.`employees` (`name`, `email`, `salary`) VALUES (?, ?, ?)";
	String GENERIC_UPDATE = "UPDATE `company`.`employees` SET name = ?, email = ?, salary = ?, date = ? WHERE emp_id = ?";
	String GENERIC_DELETE = "DELETE FROM `company`.`employees` WHERE emp_id = ?";
	String GENERIC_FIND = "SELECT * FROM company.employees";
	
	String GENERIC_FINDBYID = "SELECT * FROM `company`.`employees` WHERE emp_id = ?";
	
	// java persistence query language
	String QUERY_ADD = "INSERT INTO `company`.`employees` (`name`, `email`, `salary`) VALUES (:name, :email, :salary)";
	String QUERY_UPDATE = "UPDATE `company`.`employees` SET name = :name, email = :email, salary = :salary, date = :date WHERE emp_id = :empId";
	String QUERY_DELETE = "DELETE FROM `company`.`employees` WHERE emp_id = :empId";
	
	String QUERY_FINDBYID = "SELECT * FROM `company`.`employees` WHERE emp_id = :empId";
}
