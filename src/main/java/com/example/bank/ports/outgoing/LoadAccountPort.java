package com.example.bank.ports.outgoing;

import com.example.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Optional;

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);

    BigDecimal checkAmount(Long id);
}