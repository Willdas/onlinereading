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

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan
@EnableAutoConfiguration
//关闭自动配置   该注解包含以上三种
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
