package com.atguigu.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
@Component
public class Car implements InitializingBean,DisposableBean{

	public Car() {
		System.out.println("car...constructor...");
	}
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	//在属性设置完成后的方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("car的属性设置完成执行的方法：。。。");
		
	}

}
