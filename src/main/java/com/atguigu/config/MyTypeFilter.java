package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
/**
 * 自定义组件扫描规则
 * @author 51019
 *
 */
public class MyTypeFilter implements TypeFilter {

	/**
	 * MetadataReader：读取到当前正在扫描的类的信息
	 * MetadataReaderFactory：获取到所有的类的信息
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前扫描的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前扫描的类的名字
		String className = classMetadata.getClassName();
		if(className.contains("service")) {
			return true;
		}
		return false;
	}

}
