package com.course.course.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.course.dao.StudentService;
import com.course.course.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

	private final StudentService service;
	
	@Autowired
	public StudentResource(StudentService studService) {
		service = studService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Student> getAllStudents(){
		return new ArrayList<Student>(service.getAllStudents());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void insterNewStudent(@RequestBody Student s) {
		service.persistNewStudent(s.getId(), s);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="{sid}")
	public Student getStudentById(@PathVariable("sid") UUID uid) {
		return service.getStuentById(uid);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public int updateStudentById(@RequestBody Student s) {
		return service.updateStudnetById(s);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,path="{sid}")
	public void deleteStudentById(@PathVariable("sid") UUID uid) {
		service.deleteStudentById(uid);
	}
}
