package com.example.bank;

import com.example.bank.domain.BankAccount;
import com.example.bank.respositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

//Hexagonal architecture is an architectural style that focuses on keeping the business logic decoupled from external concerns.
//The business core interacts with other components through ports and adapters.
//This way, we can change the underlying technologies without having to modify the application core.
@SpringBootApplication
public class BankApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Bean
	public CommandLineRunner bootstrapData(BankAccountRepository repository) {
		return (args) -> {
			BigDecimal initialBalance = BigDecimal.valueOf(1000);
			BankAccount bankAccount = new BankAccount(0L, initialBalance);
			repository.save(bankAccount);
		};
	}

}
