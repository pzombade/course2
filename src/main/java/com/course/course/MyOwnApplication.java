package com.course.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= { "com"})

public class MyOwnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOwnApplication.class, args);
	}
}
