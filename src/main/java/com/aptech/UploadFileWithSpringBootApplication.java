package com.aptech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

@SpringBootApplication
public class UploadFileWithSpringBootApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UploadFileWithSpringBootApplication.class);
	}



	public static void main(String[] args) {
		SpringApplication.run(UploadFileWithSpringBootApplication.class, args);
	}
}
