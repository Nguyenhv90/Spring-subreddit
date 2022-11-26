package com.hvn.springsubredditbackend.java.com.hvn.blogwithspringandangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BlogWithSpringAndAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogWithSpringAndAngularApplication.class, args);
	}

}
