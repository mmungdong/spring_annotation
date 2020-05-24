package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atguigu.beans.Boss;
import com.atguigu.beans.Car;
import com.atguigu.dao.PersonDao;

@ComponentScan(value = {"com.atguigu.service","com.atguigu.dao","com.atguigu.beans"})
@Configuration
public class MainConfigOfAutowried {
	
	
	@Bean("personDao02")
	public PersonDao personDao() {
		PersonDao personDao = new PersonDao(); 
		personDao.setLabel("2");
		return personDao;
	}

	@Bean
	public Boss boss(Car car) {
		Boss boss = new Boss(car);
		boss.setCar(car);
		return boss;
	}
}
