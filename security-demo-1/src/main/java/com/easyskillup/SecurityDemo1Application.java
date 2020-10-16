package com.easyskillup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.easyskillup")
public class SecurityDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemo1Application.class, args);
	}

}
