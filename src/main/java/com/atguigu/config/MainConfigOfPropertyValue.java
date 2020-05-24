package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.atguigu.beans.Person;

@PropertySource(value= {"person.properties"})
@Configuration
public class MainConfigOfPropertyValue {
	
	@Bean
	public Person person() {
		return new Person();
	}

}
