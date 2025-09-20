package com.example.demo.emp.dao;

import java.util.List;

public interface BasicDao<M, Id> {
	
	void add(M m);
	void update(M m);
	void delete(M m);
	List<M> find();
	
	M findById(Id id);
	void createSql();
	
}
