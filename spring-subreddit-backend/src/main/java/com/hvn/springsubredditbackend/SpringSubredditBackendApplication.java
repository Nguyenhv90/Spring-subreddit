package com.hvn.springsubredditbackend;

import com.hvn.springsubredditbackend.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SpringSubredditBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSubredditBackendApplication.class, args);
	}

}
