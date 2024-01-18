package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.onetomany.CompanyBean;

public class CompanyMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("CompanyConfig.xml");
		CompanyBean company1 = (CompanyBean) context.getBean("company1");
		System.out.println(company1);
		((ClassPathXmlApplicationContext)context).close();
	}
}
