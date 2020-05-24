package com.atguigu.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 实体类：Yellow
 * 测试实现aware注入Spring底层组件
 * @author 51019
 *
 */
@Component
public class Yellow implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware{

	private ApplicationContext applicationContext;
	
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("你好${os.name},我是CentOs");
		System.out.println(resolveStringValue);
		
	}

	public void setBeanName(String name) {
		System.out.println("当前bean的名字："+name);
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
		
	}

	@Override
	public String toString() {
		return "Yellow [applicationContext=" + applicationContext + "]";
	}
	
	

}
