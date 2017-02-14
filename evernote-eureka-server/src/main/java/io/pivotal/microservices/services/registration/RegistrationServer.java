package io.pivotal.microservices.services.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RegistrationServer.class).properties("spring.config.name:registration-server");
	}

	public static void main(String[] args) {
		// Tell Boot to look for registration-server.yml
		System.setProperty("spring.config.name", "registration-server");
		//SpringApplication.run(RegistrationServer.class, args);
		
		 new SpringApplicationBuilder(RegistrationServer.class)
         .properties("spring.config.name:registration-server").build().run(args);
	}
}
