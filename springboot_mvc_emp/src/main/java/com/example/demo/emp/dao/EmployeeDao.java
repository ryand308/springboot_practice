package com.example.demo.emp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.emp.model.Employee;
import com.example.demo.emp.sql.EmployeeSql;

@Repository
public class EmployeeDao implements BasicDao<Employee, Long> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createSql() {
		// TODO Auto-generated method stub
		jdbcTemplate.execute(EmployeeSql.CREATE_EMPLOYEE);
	}

	@Override
	public void add(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_ADD, m.getName(), m.getEmail(), m.getSalary());
	}

	@Override
	public void update(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_UPDATE, m.getName(), m.getEmail(), m.getSalary(), m.getDate(),
				m.getEmpId());

	}

	@Override
	public void delete(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_DELETE, m.getEmpId());
	}

	@Override
	public List<Employee> find() {
		// BeanRropertyRowMapper 是 RowMapper 的 子類別，自動對應java's name of field；忽略名稱的大小寫。

		List<Employee> list = jdbcTemplate.query(EmployeeSql.GENERIC_FIND, new BeanPropertyRowMapper<>(Employee.class));

		return list;
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		Employee emp = null;
		try {
			emp = jdbcTemplate.queryForObject(EmployeeSql.GENERIC_FINDBYID, new BeanPropertyRowMapper<>(Employee.class),
					id);

		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			System.out.println("id: " + id + " 不存在 dataBase");
			// redirect to error's page;
		}

		return emp;
	}
}
