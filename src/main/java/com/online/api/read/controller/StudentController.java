package com.online.api.read.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.api.read.domain.Student;
import com.online.api.read.service.StudentService;
import com.online.commons.util.UniversalPage;

/**
 * Cotroller
 * @author willdas
 *
 */
@Controller
@RequestMapping("/api")
public class StudentController {
	
	/**
	 * 打印日志
	 */
	private final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 查找所有学生
	 * @return
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAll() {
		log.debug("获取所有学生");
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
	}
	
	/**
	 * 根据id查找学生
	 */
	@RequestMapping("/oneStudent")
	public void getStudent(String id){
		Student student = studentService.findOne(id);
		System.out.println(student);
	}
	
	/**
	 * 根据id删除学生
	 */
	@RequestMapping("/delStudentById")
	@ResponseBody
	public String delStudent(String id){
		String count = String.valueOf(studentService.delete(id));
		return count;
	}
	/**
	 * 添加学生
	 * @param name
	 * @return
	 */
	@RequestMapping("/addStudent")
	public ResponseEntity<Student> addStudent(String name){
		Student student = new Student();
		student.setName(name);
		log.info("添加学生"); 
		Student student1 = studentService.save(student);
		return new ResponseEntity<>(student1, HttpStatus.OK);
	}
	
	/**
	 * 修改学生信息
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(String id,String name){
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		Student student1 = studentService.update(student);
		log.info("修改学生名称");
		return new ResponseEntity<>(student1,HttpStatus.OK);
	}
	
	@RequestMapping("/getPage")
	public void getPageInfo(Integer pageNum,Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNum,pageSize);
		List<Student> students = studentService.findAll();
		PageInfo<Student> studentPage = UniversalPage.pageInfo(students);
		System.out.println(studentPage.getPages());
		System.out.println(studentPage.getPageNum());
		System.out.println(studentPage.getList());
	}
}
