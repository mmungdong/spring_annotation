package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.atguigu.beans.Person;

/**
 * spring配置
 * @author 51019
 *@Configuration 告诉spring这是一个配置类
 *@ComponentScan 组件扫描
 *value 指定要扫描的包
 *excludeFilters 排除扫描那些组件，其类型是一个filter数组
 *type 按注解类型排除
 *classes 排除的类
 *
 *includeFilters 只扫描哪些组件
 *useDefaultFilters=false  禁用掉默认的扫描规则
 */
@Configuration 		
/*
 * @ComponentScan(value="com.atguigu",excludeFilters= {
 * 
 * @Filter(type=FilterType.ANNOTATION,classes={Controller.class}) })
 */
@ComponentScans(value= {
		@ComponentScan(value="com.atguigu",includeFilters= {
				@Filter(type=FilterType.CUSTOM,classes= {MyTypeFilter.class})
		},useDefaultFilters=false)
})
public class MainConfig {
	/**
	 *spring容器 注入的bean
	 * @return
	 */
	@Bean("pig")
	public Person person() {
		return new Person("lisi",20,"女");
	}

}
