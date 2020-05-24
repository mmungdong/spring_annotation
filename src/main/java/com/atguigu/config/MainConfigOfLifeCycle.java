package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.atguigu.beans.Car;
import com.atguigu.beans.Cat;
@ComponentScan("com.atguigu.beans")
@Configuration
public class MainConfigOfLifeCycle {
	
	@Bean(initMethod="init",destroyMethod="destory")
	public Cat cat() {
		return new Cat();
	}
	
	@Bean
	public Car car() {
		return new Car();
	}
	

}
