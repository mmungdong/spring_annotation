package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
	
	private void getBeanDefinitionNames() {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String bean : definitionNames) {
			System.out.println(bean);
		}
	}
	
	@Test
	public void test01() {
		
		getBeanDefinitionNames();
		applicationContext.close();
	}
	

}
