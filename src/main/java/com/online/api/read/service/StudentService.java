package com.online.api.read.service;

import com.online.api.read.domain.Student;
import com.online.commons.service.BaseService;

public interface StudentService extends BaseService<Student>{
	
	//扩展方法 根据名称查学生
	Student findStudentByName(String name);
}
