package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import com.jspiders.springcoreannotations.beans.StudentBean;

public class StudentConfig {

	// =======Using setters to set the values ======
	
//	@Bean ("student1")
//	public StudentBean getStudent() {
//		StudentBean student = new StudentBean();
//		student.setId(1);
//		student.setName("Satish");
//		student.setEmail("satish@gmail.com");
//		return student;
//	}
	
	// ======= or using Value Annotations ========
	
	@Bean ("student1")
	public StudentBean getStudent() {
		return new StudentBean(1,"Satish","satish123@gmail.com");
	}
}
