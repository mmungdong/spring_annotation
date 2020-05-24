package com.atguigu.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfigOfProfile;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class IOCTest_Profile {
	
	
	//1.使用命令行动态参数：再虚拟机参数位置加载 -Dspring.profiles.active
	//2.代码的方式激活环境【AnnotationConfigApplicationContext的无参构造器】
	@Test
	public void test01() {
		//1.使用AnnotationConfigApplicationContext的无参构造器创建一个applicationContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//2.设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		//3.注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4启动刷新容器
		applicationContext.refresh();
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
	}

}
