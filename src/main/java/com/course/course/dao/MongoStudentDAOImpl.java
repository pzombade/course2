package com.course.course.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.course.model.Student;

@Repository("mongoStudentDAO")
public class MongoStudentDAOImpl implements StudentDAO {
	
	
	private Map<UUID,Student> database;
	
	@Autowired
	public MongoStudentDAOImpl() {
		database = new HashMap<UUID, Student>();
		UUID key = UUID.randomUUID();
		database.put(key , new Student(key, 5, "Mongo", "Database", "SpringBoot"));
	}
	

	@Override
	public int insertNewStudent(UUID uid, Student student) {
		database.put(uid, student);
		return 1;
	}

	@Override
	public Student selectStuentById(UUID uid) {
		return database.get(uid);
	}

	@Override
	public List<Student> selectAllStudents() {
		return new ArrayList<Student>(database.values());
	}

	@Override
	public int updateStudnetById(UUID uid, Student student) {
		database.put(uid, student);
		return 0;
	}

	@Override
	public int deleteStudentById(UUID uid) {
		database.remove(uid);
		
		return 0;
	}

}
