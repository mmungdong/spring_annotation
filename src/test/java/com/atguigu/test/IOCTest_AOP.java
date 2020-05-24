package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.aop.MathCalculator;
import com.atguigu.beans.Car;
import com.atguigu.config.MainConfigOfAOP;
import com.atguigu.config.MainConfigOfAutowried;
import com.atguigu.service.PersonService;

public class IOCTest_AOP {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
	
	private void getBeanDefinitionNames() {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String bean : definitionNames) {
			System.out.println(bean);
		}
	}
	
	@Test
	public void test01() {
		//MathCalculator必须从容器中取出，不要自己去new
		MathCalculator bean = applicationContext.getBean(MathCalculator.class);
		bean.div(10, 0);
	}
	
}


