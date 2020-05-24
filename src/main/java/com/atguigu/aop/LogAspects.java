package com.atguigu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 切面类
 *@Aspect：告诉spring这是一个切面类
 */
@Aspect
public class LogAspects {
	
	//抽取公共的切入点表达式
	//1.本类引用
	//2.其他的切面引用
	@Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
	public void pointCut() {
		
	};
	
	//@Before在目标方法之前进切入，切入点表达式（指定在哪个方法切入）
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName()+"方法运行之前。。。其参数列表为{"+Arrays.asList(args)+"}");
	}
	
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"方法结束");
	}
	
	//切面类多个参数时，JoinPoint必须放在第一个参数位置
	@AfterReturning(value="pointCut()",returning="returnning")
	public void logReturn(JoinPoint joinPoint,Object returnning) {
		System.out.println(joinPoint.getSignature().getName()+"方法正常运行，返回结果为{"+returnning+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing = "exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println(joinPoint.getSignature().getName()+"方法异常，异常信息为{"+exception+"}");
	}

}
