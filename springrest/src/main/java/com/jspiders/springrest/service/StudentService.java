package com.jspiders.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.springrest.pojo.StudentPojo;
import com.jspiders.springrest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPojo addStudent(StudentPojo pojo) {
		StudentPojo student = repository.addStudent(pojo);
		return student;
	}

//search student by using @RequestBody
	// using this annotation we have to search the data inside the body in postman
	public StudentPojo searchStudent(int id) {
		StudentPojo student = repository.searchStudent(id);
		return student;
	}

//search student by using @PathVariable
	// using this annotation we have to search the data inside the body in postman
	public StudentPojo searchStudentPath(int id) {
		StudentPojo student = repository.searchStudentPath(id);
		return student;
	}

	public List<StudentPojo> searchAllStudents() {
		List<StudentPojo> students = repository.searchAllStudents();
		return students;
	}

	public StudentPojo removeStudent(int id) {
		StudentPojo student = repository.removeStudent(id);
		return student;
	}

	public StudentPojo updateStudent(StudentPojo pojo) {
		StudentPojo student = repository.updateStudent(pojo);
		return student;
	}

}
