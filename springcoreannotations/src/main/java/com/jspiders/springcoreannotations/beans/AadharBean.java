package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AadharBean {

	@Value("1")
	int id;
	@Value("123456789098")
	double aadhar_no;
	@Value("20-05-2001")
	String date_of_issue;
}
