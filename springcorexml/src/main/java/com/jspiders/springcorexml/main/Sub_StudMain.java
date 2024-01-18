package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.manytomany.StudentBean;
import com.jspiders.springcorexml.bean.manytomany.SubjectBean;

public class Sub_StudMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Sub_StudConfig.xml");
		StudentBean student1 = (StudentBean) context.getBean("student1");
		StudentBean student2 = (StudentBean) context.getBean("student2");
		
		SubjectBean subject1 = (SubjectBean) context.getBean("subject1");
		SubjectBean subject2 = (SubjectBean) context.getBean("subject2");
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(subject1);
		System.out.println(subject2);
		((ClassPathXmlApplicationContext)context).close();
	}
}
