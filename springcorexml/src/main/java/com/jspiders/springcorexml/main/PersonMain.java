package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.onetoone.PersonBean;

public class PersonMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("PersonConfig.xml");
		PersonBean person1 = (PersonBean) context.getBean("person1");
		System.out.println(person1);
		((ClassPathXmlApplicationContext)context).close();
	}
}
