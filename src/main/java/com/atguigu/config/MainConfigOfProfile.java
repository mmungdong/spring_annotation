package com.atguigu.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Profile：Spring为我们提供的可以根据当前环境，动态的激活一系列组件的功能
 * @author 51019
 * 
 * @Profile :指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中
 * 2）、写在配置类上，只有是指顶环境的时候，整个配置类里面的所有配置才能生效
 * 3）、没有标注环境标识的bean在任何环境下都是加载的
 */
//利用注解的方式导入外部配置文件
@Profile("test")
@PropertySource("classpath:/dbConfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{
	
	@Value("${jdbc.User}")
	private String user;
	
	private StringValueResolver valueResolver;
	
	private String driverClass;

	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("jdbc.Password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
		}
	
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("jdbc.Password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
		}
	
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("jdbc.Password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
		}

	//通过实现EmbeddedValueResolverAware接口可以获取值解析器,然后利用值解析器可以将配置文件中的值提取出来
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.valueResolver = resolver;
		this.driverClass = valueResolver.resolveStringValue("${jdbc.DriverClass}");
		}

}
