package com.atguigu.beans;

import org.springframework.beans.factory.FactoryBean;
/**
 * 创建一个color的FactoryBean
 * @author 51019
 *
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Color();
	}

	//是否单例？
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	//返回类型
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

}
