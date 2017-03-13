package com.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
@EnableAutoConfiguration
//关闭自动配置   该注解包含以上三种
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Application extends DispatcherServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 拦截访问.do
	 * @param dispatcherServlet
	 * @return
	 */
	@Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        //registration.addUrlMappings("/");
        registration.addUrlMappings("/eBook");
        return registration;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
