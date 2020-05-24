package com.atguigu.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	
	public Dog() {
		System.out.println("dog...constrostor");
	};
	
	//对bean属性复制完成后执行的方法
	@PostConstruct
	public void init() {
		System.out.println("dog...init after...");
	}
	
	//在bean销毁之前执行的方法
	@PreDestroy
	public void destory() {
		System.out.println("dog...before destroy... ");
	}
}
