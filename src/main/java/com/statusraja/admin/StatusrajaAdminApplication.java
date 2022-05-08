package com.statusraja.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:/properties/application-${spring.profiles.active}.properties")
public class StatusrajaAdminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StatusrajaAdminApplication.class, args);
	}

}
