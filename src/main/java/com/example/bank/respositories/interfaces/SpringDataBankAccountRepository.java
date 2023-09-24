package com.example.bank.respositories.interfaces;

import com.example.bank.domain.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataBankAccountRepository extends MongoRepository<BankAccount, Long> { }
