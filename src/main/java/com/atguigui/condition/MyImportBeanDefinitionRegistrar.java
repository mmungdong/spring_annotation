package com.atguigui.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.beans.RainBow;
/**
 * ImportBeanDefinitionRegistrar：手动自定义注册组件
 * @author 51019
 * AnnotationMetadata：当前类的信息
 * BeanDefinitionRegistry：BeanDefinition注册类
 *     利用BeanDefinitionRegistry.registerBeanDefinition(组件名，beanDefinition)方法进行手动注册组件
 */
public class MyImportBeanDefinitionRegistrar implements  ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean containsBeanDefinition = registry.containsBeanDefinition("张若楠");
		BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
		if(containsBeanDefinition) {
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	}

}
