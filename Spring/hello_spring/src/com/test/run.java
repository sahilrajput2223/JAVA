package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.student.Student;

public class run {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("helloStudent.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		Student student = (Student) beanFactory.getBean("studentbean");
		
		student.display();
	}

}
