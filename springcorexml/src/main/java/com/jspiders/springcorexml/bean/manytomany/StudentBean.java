package com.jspiders.springcorexml.bean.manytomany;

import java.util.List;

import lombok.Data;

@Data
public class StudentBean {

	int id;
	String name;
	String email;
	String address;
	List<SubjectBean> subjects;
}
