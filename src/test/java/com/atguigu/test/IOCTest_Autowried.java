package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.Car;
import com.atguigu.config.MainConfigOfAutowried;
import com.atguigu.service.PersonService;

public class IOCTest_Autowried {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowried.class);
	
	private void getBeanDefinitionNames() {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String bean : definitionNames) {
			System.out.println(bean);
		}
	}
	/**
	 * 测试xxxAware注入Spring底层组件&原理
	 */
	@Test
	public void test03() {
		System.out.println("=================================");
		System.out.println(applicationContext);
		Object bean = applicationContext.getBean("yellow");
		System.out.println(bean);
	}
	
	/**
	 * 1.测试标注在方法位置的@Autowired注入的bean是否从容器中获取
	 * 2.构造器中自动注入的参数值是否从容器中获取
	 */
	@Test
	public void test02() {
		//1
//		Car car = (Car) applicationContext.getBean("car");
//		Object bean = applicationContext.getBean("boss");
//		System.out.println(car);
//		System.out.println(bean);
		
		//2
		Object bean = applicationContext.getBean("boss");
		System.out.println(bean);
		Object bean2 = applicationContext.getBean("car");
		System.out.println(bean2);
		
	}
	
	@Test
	public void test01() {
		getBeanDefinitionNames();
		PersonService bean = applicationContext.getBean(PersonService.class);
		System.out.println(bean);
		
	}

}


