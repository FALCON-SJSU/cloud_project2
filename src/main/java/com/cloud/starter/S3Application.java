package com.cloud.starter;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cloud.service.AmazonClientService;

@SpringBootApplication
@EntityScan("com.cloud.model")
@EnableJpaRepositories("com.cloud.repository")
@ComponentScan(basePackages = { "com.cloud.controller","com.cloud.config","com.cloud.service"})
public class S3Application {
	
	@Resource
	AmazonClientService amazonClientService;

	public static void main(String[] args) {
		
		SpringApplication.run(S3Application.class, args);

	}

}
