package com.course.course.dao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.course.course.model.Student;


@Resource
@Component
public class StudentService {
	
	private final StudentDAO studentDao;
	
	@Autowired
	public StudentService(@Qualifier("mongoStudentDAO") StudentDAO sd) {
		studentDao = sd;
	}

	public int persistNewStudent(UUID uid, Student student) {
		UUID sid = uid==null?UUID.randomUUID():uid;
		student.setId(sid);
		return studentDao.insertNewStudent(sid, student);
	}
	
	public Student getStuentById(UUID uid) {
		return studentDao.selectStuentById(uid);
	}
	
	
	public List<Student> getAllStudents(){
		return studentDao.selectAllStudents();
	}
	
	public int updateStudnetById(Student student) {
		return studentDao.updateStudnetById(student.getId(), student);
	}
	
	public int deleteStudentById(UUID uid) {
		
		Student st =  studentDao.selectStuentById(uid);
		System.out.println("Trying to delete a student .. uid="+uid+" student="+st);
		studentDao.deleteStudentById(uid);
		
		if(st==null) {
			throw new IllegalStateException();
		}
		
		return 0;
	}
}
