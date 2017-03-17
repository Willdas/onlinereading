package com.online.commons.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.online.commons.dao.BaseDao;
import com.online.commons.domain.AbstractEntity;
import com.online.commons.service.BaseService;
import com.online.commons.util.IdGen;

@Transactional
public abstract class BaseServiceImpl<T extends AbstractEntity> implements BaseService<T>{
	
	protected abstract BaseDao<T,String> baseDao();
	
	protected Class<T> entityClazz;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClazz = (Class<T>) params[0];
	}

	@Override
	public T create(T entity) {
		Assert.notNull(entity);
		String id = entity.getId() == null ? IdGen.uuid() : entity.getId().trim();
		entity.setId(id);
		System.out.println(entity);
		baseDao().insert(entity);
		return entity;
	}
	
	@Override
	public T update(T entity) {
		Assert.notNull(entity);
		T existing = baseDao().selectByPrimaryKey(entity.getId());
		BeanUtils.copyProperties(entity, existing);
		baseDao().updateByPrimaryKeySelective(existing);
		return findOne(entity.getId());
	}

	@Override
	public T save(T entity) {
		Assert.notNull(entity);
		if (findOne(entity.getId()) == null) {
			create(entity);
		} else {
			update(entity);
		}
		return findOne(entity.getId());
	}
	
	@Override
	@Transactional(readOnly = true)
	public T findOne(String id) {
		Assert.notNull(id);
		return baseDao().selectByPrimaryKey(id);
	}
	
	@Override
	public boolean exists(String id) {
		Assert.notNull(id);
		return findOne(id) != null;
	}
	
	@Override
	public long count() {
		return baseDao().countByExample(null);
	}
	
	@Override
	public int delete(String id) {
		Assert.notNull(id);
		return baseDao().deleteByPrimaryKey(id);
	}
	
	@Override
	public void delete(T entity) {
		Assert.notNull(entity);
		baseDao().deleteByPrimaryKey(entity.getId());
	}
	
	@Override
	public void deleteAll() {
		delete(findAll());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return baseDao().selectByExample(null);
	}
}
