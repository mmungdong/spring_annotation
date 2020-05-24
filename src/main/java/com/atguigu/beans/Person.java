package com.atguigu.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * 实体类：person
 * @author 51019
 *
 */
public class Person {
	@Value("agenla")
	private String name;
	@Value("18")
	private Integer age;
	@Value("女")
	private String gender;
	@Value("${email}")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email + "]";
	}
	public Person() {
		super();
	}
	public Person(String name, Integer age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	

}
