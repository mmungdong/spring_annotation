package com.atguigui.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition{

	/**
	 * ConditionContext:判断条件能使用的上下文环境
	 * AnnotatedTypeMetadata：注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if(property.contains("Windows")) {
			return true;
		}
		
		return false;
	}

}
