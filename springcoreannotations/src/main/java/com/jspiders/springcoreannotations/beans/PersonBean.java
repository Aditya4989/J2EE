package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class PersonBean {

	@Value("1")
	int id ;
	@Value("Aniket")
	String name;
	@Value("9767565656")
	double contact;
	
	@Autowired
	AadharBean aadhar;
}
