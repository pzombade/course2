package com.course.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages= { "com"})

public class MyOwnApplication {
	
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MyOwnApplication.class, args);
		
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	} 
	
	private static ApplicationContext applicationContext; 
}
