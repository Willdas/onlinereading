package com.online.api.read.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.online.api.read.dao.StudentMapper;
import com.online.api.read.domain.Student;
import com.online.api.read.service.StudentService;
import com.online.commons.dao.BaseDao;
import com.online.commons.service.impl.BaseServiceImpl;

@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public void delete(List<Student> entities) {
		
	}

	@Override
	public Student findStudentByName(String name) {
		return null;
	}

	@Override
	protected BaseDao<Student, String> baseDao() {
		return studentMapper;
	}

}
