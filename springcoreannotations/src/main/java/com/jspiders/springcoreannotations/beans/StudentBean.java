package com.jspiders.springcoreannotations.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class StudentBean {

	
	int id ;
	String name;
	String email;
	

//	=====Using Va	lue Annotation =====
	
//	@Value("1")
//	int id ;
//	@Value("Satish")
//	String name;
//	@Value("satish@gmail.com")
//	String email;
}
