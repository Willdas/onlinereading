package com.online.commons.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T extends Serializable>{

	T create(T entity);
	
	T update(T entity);
	
	T save(T entity);
	
	T findOne(String id);
	
	boolean exists(String id);
	
	long count();
	
	int delete(String id);
	
	void delete(T entity);
	
	void delete(List<T> entities);
	
	void deleteAll();
	
	List<T> findAll();
	
}
