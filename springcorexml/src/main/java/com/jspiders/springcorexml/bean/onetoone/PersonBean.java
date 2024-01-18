package com.jspiders.springcorexml.bean.onetoone;

import lombok.Data;

@Data
public class PersonBean {
	int id ;
	String name;
	double contact;
	AadharBean aadhar;
}
