package com.atguigu.config;
/**
 * aop(动态代理):指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式；
 * 1.导入aop模块；Spring AOP;(spring-aspects)
 * 2.定义一个业务逻辑类(MathCalculator.java),在业务逻辑运行的时候将日志尽心打印（方法之前，方法运行结束，方法出现异常，xxx）
 * 3.定义一个日志切面类（LogAspects.java），切面类的方法需要动态的感知方法运行到哪里
 * 通知方法：
 *  前置通知：logStart，在目标方法（div）运行之前运行
 *  后置通知：logEnd，在目标方法运行结束之后运行
 *  返回通知：logReturn，在目标方法正常返回之后运行
 *  异常通知：logException，在目标方法出现异常之后进行
 *  环绕通知：动态代理，手动推进目标方法运行（joinPoint.procceed()）
 * 4.给切面类的目标方法标注何时何地运行（通知注解）
 * 5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
 * 6.必须告诉spring哪个类是切面类（给切面类加上一个注解：@Aspect）
 * 【7】.给配置类中加@EnableAspectJAutoProxy【开启基于注解的aop模式】
 *    在spring中很多的@Enable...
 *    
 * 三步：
 * 1）：将业务逻辑组件和切面类都加入到容器中；告诉spring哪个时切面类（@Aspect）
 * 2）：在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3）：开启基于注解的aop模式；@EnableAspectJAutoProxy
 * 
 * 1.AOP原理【给容器中注册了什么组件，这个组件什么时候工作，这个组件 的源码是什么】：
 * 		@EnableAspectJAutoProxy
 *      @Import(AspectJAutoProxyRegistrar.class)给容器中导入AspectJAutoProxyRegistrar
 *                 利用AspectJAutoProxyRegistrar给容器中注册bean
 *                 internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *     给容器中注册了AnnotationAwareAspectJAutoProxyCreator
 * 2.AnnotationAwareAspectJAutoProxyCreator 
 * 		AspectJAwareAdvisorAutoProxyCreator
 * 			AbstractAdvisorAutoProxyCreator
 * 				AbstractAutoProxyCreator
 *   			implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *   			关注BeanFactory(在bean的初始化前后做哪些事情)。自动装配BeanFactory
 * 
 *  流程：
 *  1）、传入配置类，创建ioc容器
 *  2）、注册配置类，调用refresh()刷新容器
 *  3）、registerBeanPostProcessors(beanFactory)；注册bean的后置处理器来方便拦截bean的创建
 *     		1）、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *     		2）、给容器中加别的BeanPostProcessor
 *     		3）、优先注册了实现PriorityOrdered接口的BeanPostProcessor；
 *     		4）、在给容器中注册实现了Ordered接口的BeanPostProcessor；
 *     		5）、注册没实现优先级接口的BeanPostProcessor；
 *     		6）、注册BenaPostProcessor，实际上就是创建BeanPostProcessor对象，保存至容器中；
 *     			创建internalAutoProxyCreator（）【AnnotationAwareAspectJAutoProxyCreator】
 *     			1）、创建Bean的实例
 *     			2）、populateBean；给各种bean赋值
 *     			3）、initializeBean：初始化bean；
 *     					1）、invokeAwareMethods();处理Aware的方法回调
 *     					2）、applyBeanPostProcessorsBeforeInitialization()，应用后置处理器的postProcessBeforeInitialization
 *     					3）、invokeInitMethods();执行自定义的初始化方法
 *     					4）、applyBeanPostProcessorsAfterInitialization()，应用后置处理器的postProcessAfterInitialization；
 *     			4）、BenaPostProcessor【AnnotationAwareAspectJAutoProxyCreator】创建成功
 *     		7）、把BeanPostProcessor注册到BeanFactory中；
 * ====以上是创建AnnotationAwareAspectJAutoProxyCreator的过程====
 * 		AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor 
 * 4）、finishBeanFactoryInitialization(beanFactory);完成BeanFactory的初始化工作，创建剩下的单实例Bean
 * 		1）、遍历获取容器中所有的Bean，依次创建对象getBean(beanName);
 * 			getBean()->doGetBean()->getSingleton(beanName);
 * 		2）、createBean();创建bean
 * 			1）、resolveBeforeInstantiation(beanName, mbdToUse);
 */

import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
	
	//业务逻辑类加入到容器中
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	//切面类加入到容器中
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}

}
