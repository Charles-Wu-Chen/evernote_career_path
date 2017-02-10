package io.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.microservices.services.accounts.AccountRepository;
import io.microservices.services.accounts.AccountsConfiguration;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountServiceServer {

	
	@Autowired
    AccountRepository accountRepository;
	
	public static void main (String [] args){
		System.setProperty("spring.config.name", "account-service");
		SpringApplication.run(AccountServiceServer.class, args);
	}
}
