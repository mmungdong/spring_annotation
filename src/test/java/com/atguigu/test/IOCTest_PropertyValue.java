package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfigOfPropertyValue;

public class IOCTest_PropertyValue {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
	
	@Test
	public void test01() {
		getBeanDefinitionNames(applicationContext);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
	}
	
	private void getBeanDefinitionNames(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String bean : beanDefinitionNames) {
			System.out.println(bean);
		}
	}

}
