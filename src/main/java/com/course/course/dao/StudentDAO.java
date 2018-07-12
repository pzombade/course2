package com.course.course.dao;

import java.util.List;
import java.util.UUID;

import com.course.course.model.Student;

public interface StudentDAO {

		int insertNewStudent(UUID uid, Student student);
		Student selectStuentById(UUID uid);
		List<Student> selectAllStudents();
		int updateStudnetById(UUID uid, Student student);
		int deleteStudentById(UUID uid);
}
