package com.microservice;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.microservices.exceptions.AccountNotFoundException;
import io.microservices.services.AccountServiceServer;
import io.microservices.services.accounts.Account;
import io.microservices.services.accounts.AccountRepository;
import io.microservices.services.accounts.AccountsConfiguration;
import io.microservices.services.accounts.AccountsController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsConfiguration.class)
public class DemoApplicationTests {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	
	@Autowired
	protected AccountRepository accountRepository;
	
	@Test
	public void testAccountRetrieval(){
		String accountNumber = "123456789";
		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Account account = accountRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + account);

		if (account == null)
			throw new AccountNotFoundException(accountNumber);
		else {
			assertEquals(accountNumber, account.getNumber());
		}
	}
}
