package io.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.microservices.services.accounts.AccountRepository;
import io.microservices.services.accounts.AccountsConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountServiceServer extends SpringBootServletInitializer{

	
	@Autowired
    AccountRepository accountRepository;
	
	public static void main (String [] args){
		System.setProperty("spring.config.name", "account-service");
		new SpringApplicationBuilder(AccountServiceServer.class)
        .properties("spring.config.name:account-service").build().run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AccountServiceServer.class).properties("spring.config.name:account-service");
	}

}
