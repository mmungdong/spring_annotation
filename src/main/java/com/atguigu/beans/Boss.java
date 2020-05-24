package com.atguigu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 实体类：Boss
 * @author 51019
 *
 */
@Component
public class Boss {
	
	public Car car;

	public Car getCar() {
		return car;
	}

	//@Autowired
	public void setCar(Car car) {
		this.car = car;
	}
	
	//@Autowired
	public Boss(Car car) {
		System.out.println("boss...有参构造器");
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
	

}
