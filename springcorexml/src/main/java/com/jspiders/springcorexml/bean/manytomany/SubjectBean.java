package com.jspiders.springcorexml.bean.manytomany;

import java.util.List;

import lombok.Data;

@Data
public class SubjectBean {

	int id ;
	String name;
	int duration;
	List<StudentBean> students;
}
