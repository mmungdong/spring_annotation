package com.atguigu.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atguigu.beans.Color;
import com.atguigu.beans.ColorFactoryBean;
import com.atguigu.beans.Person;
import com.atguigui.condition.LinuxCondition;
import com.atguigui.condition.MyImportBeanDefinitionRegistrar;
import com.atguigui.condition.MyImportSelector;
import com.atguigui.condition.WindowsCondition;
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MainConfig02 {
	/**
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE：容器先获取对象，在创建对象并将其放入IOC容器中
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON：在容器启动时创建一个单实例bean并将其放入IOC容器中
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST:在一次请求中创建一个bean
	 * @see org.sp1ringframework.web.context.WebApplicationContext#SCOPE_SESSION：在一次会话中创建一个bean
	 * @return
	 * 
	 * @lazy:懒加载 当获取bean的时候才开始创建对象，并将其放入IOC容器中
	 */
	//@Scope("prototype")
	@Lazy
	@Bean("张若楠")
	public Person person01() {
		System.out.println("对象创建完成。。。");
		return new Person("zhangruonan",22,"女");
	}
	/**
	 * @Conditional 按照条件注册bean
	 * @return
	 */
	@Conditional({WindowsCondition.class})
	@Bean("曹操")
	public Person person02() {
		return new Person("曹操",54,"男");
	}
	@Conditional({LinuxCondition.class})
	@Bean("刘备")
	public Person person03() {
		return new Person("刘备",46,"男");
	}
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}

}
