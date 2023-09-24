package com.example.bank.configuration;

import com.example.bank.BankApplication;
import com.example.bank.respositories.BankAccountRepository;
import com.example.bank.services.BankAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// We need to tell Spring to expose the BankAccountService as a bean,
// so it can be injected in the controller
// Defining the beans in the Adapters layer helps us maintain
// the infrastructure code decoupled from the business logic.
@Configuration
@ComponentScan(basePackageClasses = BankApplication.class)
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository, repository, repository);
    }
}