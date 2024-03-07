package com.munsun.course.students_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class StudentsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentsServiceApplication.class, args);
	}
}