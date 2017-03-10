package com.online.commons.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable,ID extends Serializable> {
	
	int deleteByExample(T entity);
	
	int deleteByPrimaryKey(ID id);
	
	int insert(T entity);
	
	List<T> selectByExample(T entities);
	
	T selectByPrimaryKey(ID id);
	
	int updateByPrimaryKeySelective(T record);
	
	int updateByPrimaryKey(T entity);

	void insertSelective(T entity);
	
	int countByExample(T example);
	
}
