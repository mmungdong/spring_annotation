package com.atguigui.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.beans.Red;

public class MyImportSelector implements ImportSelector {

	//AnnotationMetadata:获取所有标注@Import注解的所有类的信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		return new String[] {"com.atguigu.beans.Red"};
	}

}
