package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfig02;

public class IOCTest {
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
	
	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
	@Test
	public void test04() {
		Object bean = annotationConfigApplicationContext.getBean("colorFactoryBean");
		System.out.println(bean);
	}
	
	@Test
	public void test03() {
		printBeans(annotationConfigApplicationContext);
	}
	
	@Test
	public void test02() {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
	
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
		System.out.println("ioc容器创建完成");
		//Object bean01 = annotationConfigApplicationContext.getBean("person");
		//Object bean02 = annotationConfigApplicationContext.getBean("person");
		//System.out.println(bean01 == bean02);
		
	}

}
