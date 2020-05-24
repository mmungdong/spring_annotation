package com.atguigu;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfig;
/**
 * 测试类
 * @author 51019
 *
 */
public class TextClass {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = (Person) applicationContext.getBean("pig");
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}

}
