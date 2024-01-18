package com.jspiders.springcorexml.bean.manytoone;

import lombok.Data;

@Data
public class EmployeeBean {

	int id;
	String name;
	int salary;
	CompanyBean company;
}
