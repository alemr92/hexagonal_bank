package com.example.bank.ports.outgoing;

import com.example.bank.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}